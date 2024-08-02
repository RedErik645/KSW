package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RequestFutureTarget<R> implements FutureTarget<R>, RequestListener<R> {
    private static final Waiter DEFAULT_WAITER = new Waiter();
    private final boolean assertBackgroundThread;
    private GlideException exception;
    private final int height;
    private boolean isCancelled;
    private boolean loadFailed;
    private Request request;
    private R resource;
    private boolean resultReceived;
    private final Waiter waiter;
    private final int width;

    public RequestFutureTarget(int width2, int height2) {
        this(width2, height2, true, DEFAULT_WAITER);
    }

    RequestFutureTarget(int width2, int height2, boolean assertBackgroundThread2, Waiter waiter2) {
        this.width = width2;
        this.height = height2;
        this.assertBackgroundThread = assertBackgroundThread2;
        this.waiter = waiter2;
    }

    public synchronized boolean cancel(boolean mayInterruptIfRunning) {
        Request request2;
        if (isDone()) {
            return false;
        }
        this.isCancelled = true;
        this.waiter.notifyAll(this);
        if (mayInterruptIfRunning && (request2 = this.request) != null) {
            request2.clear();
            this.request = null;
        }
        return true;
    }

    public synchronized boolean isCancelled() {
        return this.isCancelled;
    }

    public synchronized boolean isDone() {
        return this.isCancelled || this.resultReceived || this.loadFailed;
    }

    @Override // java.util.concurrent.Future
    public R get() throws InterruptedException, ExecutionException {
        try {
            return doGet(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.util.concurrent.Future
    public R get(long time, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return doGet(Long.valueOf(timeUnit.toMillis(time)));
    }

    @Override // com.bumptech.glide.request.target.Target
    public void getSize(SizeReadyCallback cb) {
        cb.onSizeReady(this.width, this.height);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(SizeReadyCallback cb) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void setRequest(Request request2) {
        this.request = request2;
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized Request getRequest() {
        return this.request;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable placeholder) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadStarted(Drawable placeholder) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void onLoadFailed(Drawable errorDrawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void onResourceReady(R r, Transition<? super R> transition) {
    }

    private synchronized R doGet(Long timeoutMillis) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.assertBackgroundThread && !isDone()) {
            Util.assertBackgroundThread();
        }
        if (this.isCancelled) {
            throw new CancellationException();
        } else if (this.loadFailed) {
            throw new ExecutionException(this.exception);
        } else if (this.resultReceived) {
            return this.resource;
        } else {
            if (timeoutMillis == null) {
                this.waiter.waitForTimeout(this, 0);
            } else if (timeoutMillis.longValue() > 0) {
                long now = System.currentTimeMillis();
                long deadline = timeoutMillis.longValue() + now;
                while (!isDone() && now < deadline) {
                    this.waiter.waitForTimeout(this, deadline - now);
                    now = System.currentTimeMillis();
                }
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            } else if (this.loadFailed) {
                throw new ExecutionException(this.exception);
            } else if (this.isCancelled) {
                throw new CancellationException();
            } else if (this.resultReceived) {
                return this.resource;
            } else {
                throw new TimeoutException();
            }
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.request.RequestListener
    public synchronized boolean onLoadFailed(GlideException e, Object model, Target<R> target, boolean isFirstResource) {
        this.loadFailed = true;
        this.exception = e;
        this.waiter.notifyAll(this);
        return false;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public synchronized boolean onResourceReady(R resource2, Object model, Target<R> target, DataSource dataSource, boolean isFirstResource) {
        this.resultReceived = true;
        this.resource = resource2;
        this.waiter.notifyAll(this);
        return false;
    }

    /* access modifiers changed from: package-private */
    public static class Waiter {
        Waiter() {
        }

        /* access modifiers changed from: package-private */
        public void waitForTimeout(Object toWaitOn, long timeoutMillis) throws InterruptedException {
            toWaitOn.wait(timeoutMillis);
        }

        /* access modifiers changed from: package-private */
        public void notifyAll(Object toNotify) {
            toNotify.notifyAll();
        }
    }
}