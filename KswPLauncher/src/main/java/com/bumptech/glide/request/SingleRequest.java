package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.util.Pools;
import android.util.Log;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import com.wits.ksw.launcher.utils.Constants;
import java.util.List;
import java.util.concurrent.Executor;

public final class SingleRequest<R> implements Request, SizeReadyCallback, ResourceCallback, FactoryPools.Poolable {
    private static final String GLIDE_TAG = "Glide";
    private static final boolean IS_VERBOSE_LOGGABLE = Log.isLoggable(TAG, 2);
    private static final Pools.Pool<SingleRequest<?>> POOL = FactoryPools.threadSafe(Constants.DEFAULT_SIZE, new FactoryPools.Factory<SingleRequest<?>>() {
        /* class com.bumptech.glide.request.SingleRequest.AnonymousClass1 */

        @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
        public SingleRequest<?> create() {
            return new SingleRequest<>();
        }
    });
    private static final String TAG = "Request";
    private TransitionFactory<? super R> animationFactory;
    private Executor callbackExecutor;
    private Context context;
    private Engine engine;
    private Drawable errorDrawable;
    private Drawable fallbackDrawable;
    private GlideContext glideContext;
    private int height;
    private boolean isCallingCallbacks;
    private Engine.LoadStatus loadStatus;
    private Object model;
    private int overrideHeight;
    private int overrideWidth;
    private Drawable placeholderDrawable;
    private Priority priority;
    private RequestCoordinator requestCoordinator;
    private List<RequestListener<R>> requestListeners;
    private BaseRequestOptions<?> requestOptions;
    private RuntimeException requestOrigin;
    private Resource<R> resource;
    private long startTime;
    private final StateVerifier stateVerifier;
    private Status status;
    private final String tag;
    private Target<R> target;
    private RequestListener<R> targetListener;
    private Class<R> transcodeClass;
    private int width;

    /* access modifiers changed from: private */
    public enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    public static <R> SingleRequest<R> obtain(Context context2, GlideContext glideContext2, Object model2, Class<R> transcodeClass2, BaseRequestOptions<?> requestOptions2, int overrideWidth2, int overrideHeight2, Priority priority2, Target<R> target2, RequestListener<R> targetListener2, List<RequestListener<R>> requestListeners2, RequestCoordinator requestCoordinator2, Engine engine2, TransitionFactory<? super R> animationFactory2, Executor callbackExecutor2) {
        SingleRequest<?> acquire = POOL.acquire();
        if (acquire == null) {
            acquire = new SingleRequest();
        }
        acquire.init(context2, glideContext2, model2, transcodeClass2, requestOptions2, overrideWidth2, overrideHeight2, priority2, target2, targetListener2, requestListeners2, requestCoordinator2, engine2, animationFactory2, callbackExecutor2);
        return acquire;
    }

    SingleRequest() {
        this.tag = IS_VERBOSE_LOGGABLE ? String.valueOf(super.hashCode()) : null;
        this.stateVerifier = StateVerifier.newInstance();
    }

    private synchronized void init(Context context2, GlideContext glideContext2, Object model2, Class<R> transcodeClass2, BaseRequestOptions<?> requestOptions2, int overrideWidth2, int overrideHeight2, Priority priority2, Target<R> target2, RequestListener<R> targetListener2, List<RequestListener<R>> requestListeners2, RequestCoordinator requestCoordinator2, Engine engine2, TransitionFactory<? super R> animationFactory2, Executor callbackExecutor2) {
        this.context = context2;
        this.glideContext = glideContext2;
        this.model = model2;
        this.transcodeClass = transcodeClass2;
        this.requestOptions = requestOptions2;
        this.overrideWidth = overrideWidth2;
        this.overrideHeight = overrideHeight2;
        this.priority = priority2;
        this.target = target2;
        this.targetListener = targetListener2;
        this.requestListeners = requestListeners2;
        this.requestCoordinator = requestCoordinator2;
        this.engine = engine2;
        this.animationFactory = animationFactory2;
        this.callbackExecutor = callbackExecutor2;
        this.status = Status.PENDING;
        if (this.requestOrigin == null && glideContext2.isLoggingRequestOriginsEnabled()) {
            this.requestOrigin = new RuntimeException("Glide request origin trace");
        }
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized void recycle() {
        assertNotCallingCallbacks();
        this.context = null;
        this.glideContext = null;
        this.model = null;
        this.transcodeClass = null;
        this.requestOptions = null;
        this.overrideWidth = -1;
        this.overrideHeight = -1;
        this.target = null;
        this.requestListeners = null;
        this.targetListener = null;
        this.requestCoordinator = null;
        this.animationFactory = null;
        this.loadStatus = null;
        this.errorDrawable = null;
        this.placeholderDrawable = null;
        this.fallbackDrawable = null;
        this.width = -1;
        this.height = -1;
        this.requestOrigin = null;
        POOL.release(this);
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized void begin() {
        assertNotCallingCallbacks();
        this.stateVerifier.throwIfRecycled();
        this.startTime = LogTime.getLogTime();
        if (this.model == null) {
            if (Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
                this.width = this.overrideWidth;
                this.height = this.overrideHeight;
            }
            onLoadFailed(new GlideException("Received null model"), getFallbackDrawable() == null ? 5 : 3);
        } else if (this.status == Status.RUNNING) {
            throw new IllegalArgumentException("Cannot restart a running request");
        } else if (this.status == Status.COMPLETE) {
            onResourceReady(this.resource, DataSource.MEMORY_CACHE);
        } else {
            this.status = Status.WAITING_FOR_SIZE;
            if (Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
                onSizeReady(this.overrideWidth, this.overrideHeight);
            } else {
                this.target.getSize(this);
            }
            if ((this.status == Status.RUNNING || this.status == Status.WAITING_FOR_SIZE) && canNotifyStatusChanged()) {
                this.target.onLoadStarted(getPlaceholderDrawable());
            }
            if (IS_VERBOSE_LOGGABLE) {
                logV("finished run method in " + LogTime.getElapsedMillis(this.startTime));
            }
        }
    }

    private void cancel() {
        assertNotCallingCallbacks();
        this.stateVerifier.throwIfRecycled();
        this.target.removeCallback(this);
        Engine.LoadStatus loadStatus2 = this.loadStatus;
        if (loadStatus2 != null) {
            loadStatus2.cancel();
            this.loadStatus = null;
        }
    }

    private void assertNotCallingCallbacks() {
        if (this.isCallingCallbacks) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized void clear() {
        assertNotCallingCallbacks();
        this.stateVerifier.throwIfRecycled();
        if (this.status != Status.CLEARED) {
            cancel();
            Resource<R> resource2 = this.resource;
            if (resource2 != null) {
                releaseResource(resource2);
            }
            if (canNotifyCleared()) {
                this.target.onLoadCleared(getPlaceholderDrawable());
            }
            this.status = Status.CLEARED;
        }
    }

    private void releaseResource(Resource<?> resource2) {
        this.engine.release(resource2);
        this.resource = null;
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized boolean isRunning() {
        return this.status == Status.RUNNING || this.status == Status.WAITING_FOR_SIZE;
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized boolean isComplete() {
        return this.status == Status.COMPLETE;
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized boolean isResourceSet() {
        return isComplete();
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized boolean isCleared() {
        return this.status == Status.CLEARED;
    }

    @Override // com.bumptech.glide.request.Request
    public synchronized boolean isFailed() {
        return this.status == Status.FAILED;
    }

    private Drawable getErrorDrawable() {
        if (this.errorDrawable == null) {
            Drawable errorPlaceholder = this.requestOptions.getErrorPlaceholder();
            this.errorDrawable = errorPlaceholder;
            if (errorPlaceholder == null && this.requestOptions.getErrorId() > 0) {
                this.errorDrawable = loadDrawable(this.requestOptions.getErrorId());
            }
        }
        return this.errorDrawable;
    }

    private Drawable getPlaceholderDrawable() {
        if (this.placeholderDrawable == null) {
            Drawable placeholderDrawable2 = this.requestOptions.getPlaceholderDrawable();
            this.placeholderDrawable = placeholderDrawable2;
            if (placeholderDrawable2 == null && this.requestOptions.getPlaceholderId() > 0) {
                this.placeholderDrawable = loadDrawable(this.requestOptions.getPlaceholderId());
            }
        }
        return this.placeholderDrawable;
    }

    private Drawable getFallbackDrawable() {
        if (this.fallbackDrawable == null) {
            Drawable fallbackDrawable2 = this.requestOptions.getFallbackDrawable();
            this.fallbackDrawable = fallbackDrawable2;
            if (fallbackDrawable2 == null && this.requestOptions.getFallbackId() > 0) {
                this.fallbackDrawable = loadDrawable(this.requestOptions.getFallbackId());
            }
        }
        return this.fallbackDrawable;
    }

    private Drawable loadDrawable(int resourceId) {
        return DrawableDecoderCompat.getDrawable(this.glideContext, resourceId, this.requestOptions.getTheme() != null ? this.requestOptions.getTheme() : this.context.getTheme());
    }

    private synchronized void setErrorPlaceholder() {
        if (canNotifyStatusChanged()) {
            Drawable error = null;
            if (this.model == null) {
                error = getFallbackDrawable();
            }
            if (error == null) {
                error = getErrorDrawable();
            }
            if (error == null) {
                error = getPlaceholderDrawable();
            }
            this.target.onLoadFailed(error);
        }
    }

    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public synchronized void onSizeReady(int width2, int height2) {
        Throwable th;
        try {
            this.stateVerifier.throwIfRecycled();
            boolean z = IS_VERBOSE_LOGGABLE;
            if (z) {
                logV("Got onSizeReady in " + LogTime.getElapsedMillis(this.startTime));
            }
            if (this.status == Status.WAITING_FOR_SIZE) {
                this.status = Status.RUNNING;
                float sizeMultiplier = this.requestOptions.getSizeMultiplier();
                this.width = maybeApplySizeMultiplier(width2, sizeMultiplier);
                this.height = maybeApplySizeMultiplier(height2, sizeMultiplier);
                if (z) {
                    logV("finished setup for calling load in " + LogTime.getElapsedMillis(this.startTime));
                }
                try {
                    try {
                        this.loadStatus = this.engine.load(this.glideContext, this.model, this.requestOptions.getSignature(), this.width, this.height, this.requestOptions.getResourceClass(), this.transcodeClass, this.priority, this.requestOptions.getDiskCacheStrategy(), this.requestOptions.getTransformations(), this.requestOptions.isTransformationRequired(), this.requestOptions.isScaleOnlyOrNoTransform(), this.requestOptions.getOptions(), this.requestOptions.isMemoryCacheable(), this.requestOptions.getUseUnlimitedSourceGeneratorsPool(), this.requestOptions.getUseAnimationPool(), this.requestOptions.getOnlyRetrieveFromCache(), this, this.callbackExecutor);
                        if (this.status != Status.RUNNING) {
                            this.loadStatus = null;
                        }
                        if (z) {
                            logV("finished onSizeReady in " + LogTime.getElapsedMillis(this.startTime));
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            throw th;
        }
    }

    private static int maybeApplySizeMultiplier(int size, float sizeMultiplier) {
        return size == Integer.MIN_VALUE ? size : Math.round(((float) size) * sizeMultiplier);
    }

    private boolean canSetResource() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        return requestCoordinator2 == null || requestCoordinator2.canSetImage(this);
    }

    private boolean canNotifyCleared() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        return requestCoordinator2 == null || requestCoordinator2.canNotifyCleared(this);
    }

    private boolean canNotifyStatusChanged() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        return requestCoordinator2 == null || requestCoordinator2.canNotifyStatusChanged(this);
    }

    private boolean isFirstReadyResource() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        return requestCoordinator2 == null || !requestCoordinator2.isAnyResourceSet();
    }

    private void notifyLoadSuccess() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        if (requestCoordinator2 != null) {
            requestCoordinator2.onRequestSuccess(this);
        }
    }

    private void notifyLoadFailed() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        if (requestCoordinator2 != null) {
            requestCoordinator2.onRequestFailed(this);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.bumptech.glide.request.SingleRequest<R> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.request.ResourceCallback
    public synchronized void onResourceReady(Resource<?> resource2, DataSource dataSource) {
        this.stateVerifier.throwIfRecycled();
        this.loadStatus = null;
        if (resource2 == null) {
            onLoadFailed(new GlideException("Expected to receive a Resource<R> with an object of " + this.transcodeClass + " inside, but instead got null."));
            return;
        }
        Object received = resource2.get();
        if (received == null || !this.transcodeClass.isAssignableFrom(received.getClass())) {
            releaseResource(resource2);
            onLoadFailed(new GlideException("Expected to receive an object of " + this.transcodeClass + " but instead got " + (received != null ? received.getClass() : "") + "{" + received + "} inside Resource{" + resource2 + "}." + (received != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.")));
        } else if (!canSetResource()) {
            releaseResource(resource2);
            this.status = Status.COMPLETE;
        } else {
            onResourceReady(resource2, received, dataSource);
        }
    }

    /* JADX INFO: finally extract failed */
    private synchronized void onResourceReady(Resource<R> resource2, R result, DataSource dataSource) {
        boolean anyListenerHandledUpdatingTarget;
        boolean isFirstResource = isFirstReadyResource();
        this.status = Status.COMPLETE;
        this.resource = resource2;
        if (this.glideContext.getLogLevel() <= 3) {
            Log.d(GLIDE_TAG, "Finished loading " + result.getClass().getSimpleName() + " from " + dataSource + " for " + this.model + " with size [" + this.width + "x" + this.height + "] in " + LogTime.getElapsedMillis(this.startTime) + " ms");
        }
        boolean z = true;
        this.isCallingCallbacks = true;
        try {
            List<RequestListener<R>> list = this.requestListeners;
            if (list != null) {
                anyListenerHandledUpdatingTarget = false;
                for (RequestListener<R> listener : list) {
                    anyListenerHandledUpdatingTarget |= listener.onResourceReady(result, this.model, this.target, dataSource, isFirstResource);
                }
            } else {
                anyListenerHandledUpdatingTarget = false;
            }
            RequestListener<R> requestListener = this.targetListener;
            if (requestListener == null || !requestListener.onResourceReady(result, this.model, this.target, dataSource, isFirstResource)) {
                z = false;
            }
            if (!anyListenerHandledUpdatingTarget && !z) {
                this.target.onResourceReady(result, this.animationFactory.build(dataSource, isFirstResource));
            }
            this.isCallingCallbacks = false;
            notifyLoadSuccess();
        } catch (Throwable th) {
            this.isCallingCallbacks = false;
            throw th;
        }
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public synchronized void onLoadFailed(GlideException e) {
        onLoadFailed(e, 5);
    }

    /* JADX INFO: finally extract failed */
    private synchronized void onLoadFailed(GlideException e, int maxLogLevel) {
        this.stateVerifier.throwIfRecycled();
        e.setOrigin(this.requestOrigin);
        int logLevel = this.glideContext.getLogLevel();
        if (logLevel <= maxLogLevel) {
            Log.w(GLIDE_TAG, "Load failed for " + this.model + " with size [" + this.width + "x" + this.height + "]", e);
            if (logLevel <= 4) {
                e.logRootCauses(GLIDE_TAG);
            }
        }
        this.loadStatus = null;
        this.status = Status.FAILED;
        boolean z = true;
        this.isCallingCallbacks = true;
        boolean anyListenerHandledUpdatingTarget = false;
        try {
            List<RequestListener<R>> list = this.requestListeners;
            if (list != null) {
                for (RequestListener<R> listener : list) {
                    anyListenerHandledUpdatingTarget |= listener.onLoadFailed(e, this.model, this.target, isFirstReadyResource());
                }
            }
            RequestListener<R> requestListener = this.targetListener;
            if (requestListener == null || !requestListener.onLoadFailed(e, this.model, this.target, isFirstReadyResource())) {
                z = false;
            }
            if (!z && !anyListenerHandledUpdatingTarget) {
                setErrorPlaceholder();
            }
            this.isCallingCallbacks = false;
            notifyLoadFailed();
        } catch (Throwable th) {
            this.isCallingCallbacks = false;
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0049, code lost:
        r1 = th;
     */
    @Override // com.bumptech.glide.request.Request
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean isEquivalentTo(com.bumptech.glide.request.Request r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r5 instanceof com.bumptech.glide.request.SingleRequest     // Catch:{ all -> 0x004d }
            r1 = 0
            if (r0 == 0) goto L_0x004b
            r0 = r5
            com.bumptech.glide.request.SingleRequest r0 = (com.bumptech.glide.request.SingleRequest) r0     // Catch:{ all -> 0x004d }
            monitor-enter(r0)     // Catch:{ all -> 0x004d }
            int r2 = r4.overrideWidth     // Catch:{ all -> 0x0046 }
            int r3 = r0.overrideWidth     // Catch:{ all -> 0x0046 }
            if (r2 != r3) goto L_0x0042
            int r2 = r4.overrideHeight     // Catch:{ all -> 0x0046 }
            int r3 = r0.overrideHeight     // Catch:{ all -> 0x0046 }
            if (r2 != r3) goto L_0x0042
            java.lang.Object r2 = r4.model     // Catch:{ all -> 0x0046 }
            java.lang.Object r3 = r0.model     // Catch:{ all -> 0x0046 }
            boolean r2 = com.bumptech.glide.util.Util.bothModelsNullEquivalentOrEquals(r2, r3)     // Catch:{ all -> 0x0046 }
            if (r2 == 0) goto L_0x0042
            java.lang.Class<R> r2 = r4.transcodeClass     // Catch:{ all -> 0x0046 }
            java.lang.Class<R> r3 = r0.transcodeClass     // Catch:{ all -> 0x0046 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0046 }
            if (r2 == 0) goto L_0x0042
            com.bumptech.glide.request.BaseRequestOptions<?> r2 = r4.requestOptions     // Catch:{ all -> 0x0046 }
            com.bumptech.glide.request.BaseRequestOptions<?> r3 = r0.requestOptions     // Catch:{ all -> 0x0046 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0046 }
            if (r2 == 0) goto L_0x0042
            com.bumptech.glide.Priority r2 = r4.priority     // Catch:{ all -> 0x0046 }
            com.bumptech.glide.Priority r3 = r0.priority     // Catch:{ all -> 0x0046 }
            if (r2 != r3) goto L_0x0042
            boolean r2 = r4.listenerCountEquals(r0)     // Catch:{ all -> 0x0046 }
            if (r2 == 0) goto L_0x0042
            r1 = 1
            goto L_0x0043
        L_0x0042:
        L_0x0043:
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            monitor-exit(r4)
            return r1
        L_0x0046:
            r1 = move-exception
        L_0x0047:
            monitor-exit(r0)     // Catch:{ all -> 0x0049 }
            throw r1
        L_0x0049:
            r1 = move-exception
            goto L_0x0047
        L_0x004b:
            monitor-exit(r4)
            return r1
        L_0x004d:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.isEquivalentTo(com.bumptech.glide.request.Request):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0020, code lost:
        r0 = th;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean listenerCountEquals(com.bumptech.glide.request.SingleRequest<?> r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            monitor-enter(r4)     // Catch:{ all -> 0x0022 }
            java.util.List<com.bumptech.glide.request.RequestListener<R>> r0 = r3.requestListeners     // Catch:{ all -> 0x001d }
            r1 = 0
            if (r0 != 0) goto L_0x0009
            r0 = r1
            goto L_0x000d
        L_0x0009:
            int r0 = r0.size()     // Catch:{ all -> 0x001d }
        L_0x000d:
            java.util.List<com.bumptech.glide.request.RequestListener<R>> r2 = r4.requestListeners     // Catch:{ all -> 0x001d }
            if (r2 != 0) goto L_0x0013
            r2 = r1
            goto L_0x0017
        L_0x0013:
            int r2 = r2.size()     // Catch:{ all -> 0x001d }
        L_0x0017:
            if (r0 != r2) goto L_0x001a
            r1 = 1
        L_0x001a:
            monitor-exit(r4)     // Catch:{ all -> 0x001d }
            monitor-exit(r3)
            return r1
        L_0x001d:
            r0 = move-exception
        L_0x001e:
            monitor-exit(r4)     // Catch:{ all -> 0x0020 }
            throw r0
        L_0x0020:
            r0 = move-exception
            goto L_0x001e
        L_0x0022:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.listenerCountEquals(com.bumptech.glide.request.SingleRequest):boolean");
    }

    private void logV(String message) {
        Log.v(TAG, message + " this: " + this.tag);
    }
}
