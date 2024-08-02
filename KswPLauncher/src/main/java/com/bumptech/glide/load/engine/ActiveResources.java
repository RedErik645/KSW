package com.bumptech.glide.load.engine;

import android.os.Process;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* access modifiers changed from: package-private */
public final class ActiveResources {
    final Map<Key, ResourceWeakReference> activeEngineResources;
    private volatile DequeuedResourceCallback cb;
    private final boolean isActiveResourceRetentionAllowed;
    private volatile boolean isShutdown;
    private EngineResource.ResourceListener listener;
    private final Executor monitorClearedResourcesExecutor;
    private final ReferenceQueue<EngineResource<?>> resourceReferenceQueue;

    /* access modifiers changed from: package-private */
    public interface DequeuedResourceCallback {
        void onResourceDequeued();
    }

    ActiveResources(boolean isActiveResourceRetentionAllowed2) {
        this(isActiveResourceRetentionAllowed2, Executors.newSingleThreadExecutor(new ThreadFactory() {
            /* class com.bumptech.glide.load.engine.ActiveResources.AnonymousClass1 */

            public Thread newThread(final Runnable r) {
                return new Thread(new Runnable() {
                    /* class com.bumptech.glide.load.engine.ActiveResources.AnonymousClass1.AnonymousClass1 */

                    public void run() {
                        Process.setThreadPriority(10);
                        r.run();
                    }
                }, "glide-active-resources");
            }
        }));
    }

    ActiveResources(boolean isActiveResourceRetentionAllowed2, Executor monitorClearedResourcesExecutor2) {
        this.activeEngineResources = new HashMap();
        this.resourceReferenceQueue = new ReferenceQueue<>();
        this.isActiveResourceRetentionAllowed = isActiveResourceRetentionAllowed2;
        this.monitorClearedResourcesExecutor = monitorClearedResourcesExecutor2;
        monitorClearedResourcesExecutor2.execute(new Runnable() {
            /* class com.bumptech.glide.load.engine.ActiveResources.AnonymousClass2 */

            public void run() {
                ActiveResources.this.cleanReferenceQueue();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void setListener(EngineResource.ResourceListener listener2) {
        synchronized (listener2) {
            synchronized (this) {
                this.listener = listener2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void activate(Key key, EngineResource<?> resource) {
        ResourceWeakReference removed = this.activeEngineResources.put(key, new ResourceWeakReference(key, resource, this.resourceReferenceQueue, this.isActiveResourceRetentionAllowed));
        if (removed != null) {
            removed.reset();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void deactivate(Key key) {
        ResourceWeakReference removed = this.activeEngineResources.remove(key);
        if (removed != null) {
            removed.reset();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized EngineResource<?> get(Key key) {
        ResourceWeakReference activeRef = this.activeEngineResources.get(key);
        if (activeRef == null) {
            return null;
        }
        EngineResource<?> active = (EngineResource) activeRef.get();
        if (active == null) {
            cleanupActiveReference(activeRef);
        }
        return active;
    }

    /* access modifiers changed from: package-private */
    public void cleanupActiveReference(ResourceWeakReference ref) {
        synchronized (this.listener) {
            synchronized (this) {
                this.activeEngineResources.remove(ref.key);
                if (ref.isCacheable) {
                    if (ref.resource != null) {
                        EngineResource<?> newResource = new EngineResource<>(ref.resource, true, false);
                        newResource.setResourceListener(ref.key, this.listener);
                        this.listener.onResourceReleased(ref.key, newResource);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void cleanReferenceQueue() {
        while (!this.isShutdown) {
            try {
                cleanupActiveReference((ResourceWeakReference) this.resourceReferenceQueue.remove());
                DequeuedResourceCallback current = this.cb;
                if (current != null) {
                    current.onResourceDequeued();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setDequeuedResourceCallback(DequeuedResourceCallback cb2) {
        this.cb = cb2;
    }

    /* access modifiers changed from: package-private */
    public void shutdown() {
        this.isShutdown = true;
        Executor executor = this.monitorClearedResourcesExecutor;
        if (executor instanceof ExecutorService) {
            com.bumptech.glide.util.Executors.shutdownAndAwaitTermination((ExecutorService) executor);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ResourceWeakReference extends WeakReference<EngineResource<?>> {
        final boolean isCacheable;
        final Key key;
        Resource<?> resource;

        ResourceWeakReference(Key key2, EngineResource<?> referent, ReferenceQueue<? super EngineResource<?>> queue, boolean isActiveResourceRetentionAllowed) {
            super(referent, queue);
            this.key = (Key) Preconditions.checkNotNull(key2);
            this.resource = (!referent.isCacheable() || !isActiveResourceRetentionAllowed) ? null : (Resource) Preconditions.checkNotNull(referent.getResource());
            this.isCacheable = referent.isCacheable();
        }

        /* access modifiers changed from: package-private */
        public void reset() {
            this.resource = null;
            clear();
        }
    }
}
