package com.bumptech.glide.load.engine;

import android.support.v4.util.Pools;
import android.util.Log;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCacheAdapter;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.Map;
import java.util.concurrent.Executor;

public class Engine implements EngineJobListener, MemoryCache.ResourceRemovedListener, EngineResource.ResourceListener {
    private static final int JOB_POOL_SIZE = 150;
    private static final String TAG = "Engine";
    private static final boolean VERBOSE_IS_LOGGABLE = Log.isLoggable(TAG, 2);
    private final ActiveResources activeResources;
    private final MemoryCache cache;
    private final DecodeJobFactory decodeJobFactory;
    private final LazyDiskCacheProvider diskCacheProvider;
    private final EngineJobFactory engineJobFactory;
    private final Jobs jobs;
    private final EngineKeyFactory keyFactory;
    private final ResourceRecycler resourceRecycler;

    public Engine(MemoryCache memoryCache, DiskCache.Factory diskCacheFactory, GlideExecutor diskCacheExecutor, GlideExecutor sourceExecutor, GlideExecutor sourceUnlimitedExecutor, GlideExecutor animationExecutor, boolean isActiveResourceRetentionAllowed) {
        this(memoryCache, diskCacheFactory, diskCacheExecutor, sourceExecutor, sourceUnlimitedExecutor, animationExecutor, null, null, null, null, null, null, isActiveResourceRetentionAllowed);
    }

    Engine(MemoryCache cache2, DiskCache.Factory diskCacheFactory, GlideExecutor diskCacheExecutor, GlideExecutor sourceExecutor, GlideExecutor sourceUnlimitedExecutor, GlideExecutor animationExecutor, Jobs jobs2, EngineKeyFactory keyFactory2, ActiveResources activeResources2, EngineJobFactory engineJobFactory2, DecodeJobFactory decodeJobFactory2, ResourceRecycler resourceRecycler2, boolean isActiveResourceRetentionAllowed) {
        ActiveResources activeResources3;
        EngineKeyFactory keyFactory3;
        Jobs jobs3;
        EngineJobFactory engineJobFactory3;
        DecodeJobFactory decodeJobFactory3;
        ResourceRecycler resourceRecycler3;
        this.cache = cache2;
        LazyDiskCacheProvider lazyDiskCacheProvider = new LazyDiskCacheProvider(diskCacheFactory);
        this.diskCacheProvider = lazyDiskCacheProvider;
        if (activeResources2 == null) {
            activeResources3 = new ActiveResources(isActiveResourceRetentionAllowed);
        } else {
            activeResources3 = activeResources2;
        }
        this.activeResources = activeResources3;
        activeResources3.setListener(this);
        if (keyFactory2 == null) {
            keyFactory3 = new EngineKeyFactory();
        } else {
            keyFactory3 = keyFactory2;
        }
        this.keyFactory = keyFactory3;
        if (jobs2 == null) {
            jobs3 = new Jobs();
        } else {
            jobs3 = jobs2;
        }
        this.jobs = jobs3;
        if (engineJobFactory2 == null) {
            engineJobFactory3 = new EngineJobFactory(diskCacheExecutor, sourceExecutor, sourceUnlimitedExecutor, animationExecutor, this);
        } else {
            engineJobFactory3 = engineJobFactory2;
        }
        this.engineJobFactory = engineJobFactory3;
        if (decodeJobFactory2 == null) {
            decodeJobFactory3 = new DecodeJobFactory(lazyDiskCacheProvider);
        } else {
            decodeJobFactory3 = decodeJobFactory2;
        }
        this.decodeJobFactory = decodeJobFactory3;
        if (resourceRecycler2 == null) {
            resourceRecycler3 = new ResourceRecycler();
        } else {
            resourceRecycler3 = resourceRecycler2;
        }
        this.resourceRecycler = resourceRecycler3;
        cache2.setResourceRemovedListener(this);
    }

    public synchronized <R> LoadStatus load(GlideContext glideContext, Object model, Key signature, int width, int height, Class<?> resourceClass, Class<R> transcodeClass, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> transformations, boolean isTransformationRequired, boolean isScaleOnlyOrNoTransform, Options options, boolean isMemoryCacheable, boolean useUnlimitedSourceExecutorPool, boolean useAnimationPool, boolean onlyRetrieveFromCache, ResourceCallback cb, Executor callbackExecutor) {
        boolean z = VERBOSE_IS_LOGGABLE;
        long startTime = z ? LogTime.getLogTime() : 0;
        EngineKey key = this.keyFactory.buildKey(model, signature, width, height, transformations, resourceClass, transcodeClass, options);
        EngineResource<?> active = loadFromActiveResources(key, isMemoryCacheable);
        if (active != null) {
            cb.onResourceReady(active, DataSource.MEMORY_CACHE);
            if (z) {
                logWithTimeAndKey("Loaded resource from active resources", startTime, key);
            }
            return null;
        }
        EngineResource<?> cached = loadFromCache(key, isMemoryCacheable);
        if (cached != null) {
            cb.onResourceReady(cached, DataSource.MEMORY_CACHE);
            if (z) {
                logWithTimeAndKey("Loaded resource from cache", startTime, key);
            }
            return null;
        }
        EngineJob<?> current = this.jobs.get(key, onlyRetrieveFromCache);
        if (current != null) {
            current.addCallback(cb, callbackExecutor);
            if (z) {
                logWithTimeAndKey("Added to existing load", startTime, key);
            }
            return new LoadStatus(cb, current);
        }
        EngineJob<R> engineJob = this.engineJobFactory.build(key, isMemoryCacheable, useUnlimitedSourceExecutorPool, useAnimationPool, onlyRetrieveFromCache);
        DecodeJob<R> decodeJob = this.decodeJobFactory.build(glideContext, model, key, signature, width, height, resourceClass, transcodeClass, priority, diskCacheStrategy, transformations, isTransformationRequired, isScaleOnlyOrNoTransform, onlyRetrieveFromCache, options, engineJob);
        this.jobs.put(key, engineJob);
        engineJob.addCallback(cb, callbackExecutor);
        engineJob.start(decodeJob);
        if (z) {
            logWithTimeAndKey("Started new load", startTime, key);
        }
        return new LoadStatus(cb, engineJob);
    }

    private static void logWithTimeAndKey(String log, long startTime, Key key) {
        Log.v(TAG, log + " in " + LogTime.getElapsedMillis(startTime) + "ms, key: " + key);
    }

    private EngineResource<?> loadFromActiveResources(Key key, boolean isMemoryCacheable) {
        if (!isMemoryCacheable) {
            return null;
        }
        EngineResource<?> active = this.activeResources.get(key);
        if (active != null) {
            active.acquire();
        }
        return active;
    }

    private EngineResource<?> loadFromCache(Key key, boolean isMemoryCacheable) {
        if (!isMemoryCacheable) {
            return null;
        }
        EngineResource<?> cached = getEngineResourceFromCache(key);
        if (cached != null) {
            cached.acquire();
            this.activeResources.activate(key, cached);
        }
        return cached;
    }

    private EngineResource<?> getEngineResourceFromCache(Key key) {
        Resource<?> cached = this.cache.remove(key);
        if (cached == null) {
            return null;
        }
        if (cached instanceof EngineResource) {
            return (EngineResource) cached;
        }
        return new EngineResource<>(cached, true, true);
    }

    public void release(Resource<?> resource) {
        if (resource instanceof EngineResource) {
            ((EngineResource) resource).release();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    @Override // com.bumptech.glide.load.engine.EngineJobListener
    public synchronized void onEngineJobComplete(EngineJob<?> engineJob, Key key, EngineResource<?> resource) {
        if (resource != null) {
            resource.setResourceListener(key, this);
            if (resource.isCacheable()) {
                this.activeResources.activate(key, resource);
            }
        }
        this.jobs.removeIfCurrent(key, engineJob);
    }

    @Override // com.bumptech.glide.load.engine.EngineJobListener
    public synchronized void onEngineJobCancelled(EngineJob<?> engineJob, Key key) {
        this.jobs.removeIfCurrent(key, engineJob);
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache.ResourceRemovedListener
    public void onResourceRemoved(Resource<?> resource) {
        this.resourceRecycler.recycle(resource);
    }

    @Override // com.bumptech.glide.load.engine.EngineResource.ResourceListener
    public synchronized void onResourceReleased(Key cacheKey, EngineResource<?> resource) {
        this.activeResources.deactivate(cacheKey);
        if (resource.isCacheable()) {
            this.cache.put(cacheKey, resource);
        } else {
            this.resourceRecycler.recycle(resource);
        }
    }

    public void clearDiskCache() {
        this.diskCacheProvider.getDiskCache().clear();
    }

    public void shutdown() {
        this.engineJobFactory.shutdown();
        this.diskCacheProvider.clearDiskCacheIfCreated();
        this.activeResources.shutdown();
    }

    public class LoadStatus {
        private final ResourceCallback cb;
        private final EngineJob<?> engineJob;

        LoadStatus(ResourceCallback cb2, EngineJob<?> engineJob2) {
            this.cb = cb2;
            this.engineJob = engineJob2;
        }

        public void cancel() {
            synchronized (Engine.this) {
                this.engineJob.removeCallback(this.cb);
            }
        }
    }

    private static class LazyDiskCacheProvider implements DecodeJob.DiskCacheProvider {
        private volatile DiskCache diskCache;
        private final DiskCache.Factory factory;

        LazyDiskCacheProvider(DiskCache.Factory factory2) {
            this.factory = factory2;
        }

        /* access modifiers changed from: package-private */
        public synchronized void clearDiskCacheIfCreated() {
            if (this.diskCache != null) {
                this.diskCache.clear();
            }
        }

        @Override // com.bumptech.glide.load.engine.DecodeJob.DiskCacheProvider
        public DiskCache getDiskCache() {
            if (this.diskCache == null) {
                synchronized (this) {
                    if (this.diskCache == null) {
                        this.diskCache = this.factory.build();
                    }
                    if (this.diskCache == null) {
                        this.diskCache = new DiskCacheAdapter();
                    }
                }
            }
            return this.diskCache;
        }
    }

    /* access modifiers changed from: package-private */
    public static class DecodeJobFactory {
        private int creationOrder;
        final DecodeJob.DiskCacheProvider diskCacheProvider;
        final Pools.Pool<DecodeJob<?>> pool = FactoryPools.threadSafe(150, new FactoryPools.Factory<DecodeJob<?>>() {
            /* class com.bumptech.glide.load.engine.Engine.DecodeJobFactory.AnonymousClass1 */

            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            public DecodeJob<?> create() {
                return new DecodeJob<>(DecodeJobFactory.this.diskCacheProvider, DecodeJobFactory.this.pool);
            }
        });

        DecodeJobFactory(DecodeJob.DiskCacheProvider diskCacheProvider2) {
            this.diskCacheProvider = diskCacheProvider2;
        }

        /* access modifiers changed from: package-private */
        public <R> DecodeJob<R> build(GlideContext glideContext, Object model, EngineKey loadKey, Key signature, int width, int height, Class<?> resourceClass, Class<R> transcodeClass, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> transformations, boolean isTransformationRequired, boolean isScaleOnlyOrNoTransform, boolean onlyRetrieveFromCache, Options options, DecodeJob.Callback<R> callback) {
            DecodeJob<R> result = (DecodeJob) Preconditions.checkNotNull(this.pool.acquire());
            int i = this.creationOrder;
            this.creationOrder = i + 1;
            return result.init(glideContext, model, loadKey, signature, width, height, resourceClass, transcodeClass, priority, diskCacheStrategy, transformations, isTransformationRequired, isScaleOnlyOrNoTransform, onlyRetrieveFromCache, options, callback, i);
        }
    }

    /* access modifiers changed from: package-private */
    public static class EngineJobFactory {
        final GlideExecutor animationExecutor;
        final GlideExecutor diskCacheExecutor;
        final EngineJobListener listener;
        final Pools.Pool<EngineJob<?>> pool = FactoryPools.threadSafe(150, new FactoryPools.Factory<EngineJob<?>>() {
            /* class com.bumptech.glide.load.engine.Engine.EngineJobFactory.AnonymousClass1 */

            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            public EngineJob<?> create() {
                return new EngineJob<>(EngineJobFactory.this.diskCacheExecutor, EngineJobFactory.this.sourceExecutor, EngineJobFactory.this.sourceUnlimitedExecutor, EngineJobFactory.this.animationExecutor, EngineJobFactory.this.listener, EngineJobFactory.this.pool);
            }
        });
        final GlideExecutor sourceExecutor;
        final GlideExecutor sourceUnlimitedExecutor;

        EngineJobFactory(GlideExecutor diskCacheExecutor2, GlideExecutor sourceExecutor2, GlideExecutor sourceUnlimitedExecutor2, GlideExecutor animationExecutor2, EngineJobListener listener2) {
            this.diskCacheExecutor = diskCacheExecutor2;
            this.sourceExecutor = sourceExecutor2;
            this.sourceUnlimitedExecutor = sourceUnlimitedExecutor2;
            this.animationExecutor = animationExecutor2;
            this.listener = listener2;
        }

        /* access modifiers changed from: package-private */
        public void shutdown() {
            Executors.shutdownAndAwaitTermination(this.diskCacheExecutor);
            Executors.shutdownAndAwaitTermination(this.sourceExecutor);
            Executors.shutdownAndAwaitTermination(this.sourceUnlimitedExecutor);
            Executors.shutdownAndAwaitTermination(this.animationExecutor);
        }

        /* access modifiers changed from: package-private */
        public <R> EngineJob<R> build(Key key, boolean isMemoryCacheable, boolean useUnlimitedSourceGeneratorPool, boolean useAnimationPool, boolean onlyRetrieveFromCache) {
            return ((EngineJob) Preconditions.checkNotNull(this.pool.acquire())).init(key, isMemoryCacheable, useUnlimitedSourceGeneratorPool, useAnimationPool, onlyRetrieveFromCache);
        }
    }
}
