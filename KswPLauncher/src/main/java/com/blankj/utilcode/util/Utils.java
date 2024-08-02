package com.blankj.utilcode.util;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.Lifecycle;
import android.util.Log;
import com.blankj.utilcode.util.ThreadUtils;

public final class Utils {
    private static Application sApp;

    public interface Consumer<T> {
        void accept(T t);
    }

    public interface Func1<Ret, Par> {
        Ret call(Par par);
    }

    public interface OnAppStatusChangedListener {
        void onBackground(Activity activity);

        void onForeground(Activity activity);
    }

    public interface Supplier<T> {
        T get();
    }

    private Utils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void init(Application app) {
        if (app == null) {
            Log.e("Utils", "app is null.");
            return;
        }
        Application application = sApp;
        if (application == null) {
            sApp = app;
            UtilsBridge.init(app);
            UtilsBridge.preLoad();
        } else if (!application.equals(app)) {
            UtilsBridge.unInit(sApp);
            sApp = app;
            UtilsBridge.init(app);
        }
    }

    public static Application getApp() {
        Application application = sApp;
        if (application != null) {
            return application;
        }
        init(UtilsBridge.getApplicationByReflect());
        if (sApp != null) {
            Log.i("Utils", UtilsBridge.getCurrentProcessName() + " reflect app success.");
            return sApp;
        }
        throw new NullPointerException("reflect failed.");
    }

    public static abstract class Task<Result> extends ThreadUtils.SimpleTask<Result> {
        private Consumer<Result> mConsumer;

        public Task(Consumer<Result> consumer) {
            this.mConsumer = consumer;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onSuccess(Result result) {
            Consumer<Result> consumer = this.mConsumer;
            if (consumer != null) {
                consumer.accept(result);
            }
        }
    }

    public static class ActivityLifecycleCallbacks {
        public void onActivityCreated(Activity activity) {
            if (activity == null) {
                throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
            }
        }

        public void onActivityStarted(Activity activity) {
            if (activity == null) {
                throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
            }
        }

        public void onActivityResumed(Activity activity) {
            if (activity == null) {
                throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
            }
        }

        public void onActivityPaused(Activity activity) {
            if (activity == null) {
                throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
            }
        }

        public void onActivityStopped(Activity activity) {
            if (activity == null) {
                throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
            }
        }

        public void onActivityDestroyed(Activity activity) {
            if (activity == null) {
                throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
            }
        }

        public void onLifecycleChanged(Activity activity, Lifecycle.Event event) {
            if (activity == null) {
                throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
            }
        }
    }
}
