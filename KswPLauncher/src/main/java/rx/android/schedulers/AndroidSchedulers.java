package rx.android.schedulers;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;

public final class AndroidSchedulers {
    private static final AtomicReference<AndroidSchedulers> INSTANCE = new AtomicReference<>();
    private final Scheduler mainThreadScheduler;

    private static AndroidSchedulers getInstance() {
        AtomicReference<AndroidSchedulers> atomicReference;
        AndroidSchedulers current;
        do {
            atomicReference = INSTANCE;
            AndroidSchedulers current2 = atomicReference.get();
            if (current2 != null) {
                return current2;
            }
            current = new AndroidSchedulers();
        } while (!atomicReference.compareAndSet(null, current));
        return current;
    }

    private AndroidSchedulers() {
        Scheduler main = RxAndroidPlugins.getInstance().getSchedulersHook().getMainThreadScheduler();
        if (main != null) {
            this.mainThreadScheduler = main;
        } else {
            this.mainThreadScheduler = new LooperScheduler(Looper.getMainLooper());
        }
    }

    public static Scheduler mainThread() {
        return getInstance().mainThreadScheduler;
    }

    public static Scheduler from(Looper looper) {
        if (looper != null) {
            return new LooperScheduler(looper);
        }
        throw new NullPointerException("looper == null");
    }

    public static void reset() {
        INSTANCE.set(null);
    }
}
