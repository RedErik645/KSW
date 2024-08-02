package rx.schedulers;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.internal.schedulers.ExecutorScheduler;
import rx.internal.schedulers.GenericScheduledExecutorService;
import rx.internal.schedulers.ImmediateScheduler;
import rx.internal.schedulers.SchedulerLifecycle;
import rx.internal.schedulers.TrampolineScheduler;
import rx.internal.util.RxRingBuffer;
import rx.plugins.RxJavaHooks;
import rx.plugins.RxJavaPlugins;
import rx.plugins.RxJavaSchedulersHook;

public final class Schedulers {
    private static final AtomicReference<Schedulers> INSTANCE = new AtomicReference<>();
    private final Scheduler computationScheduler;
    private final Scheduler ioScheduler;
    private final Scheduler newThreadScheduler;

    private static Schedulers getInstance() {
        while (true) {
            AtomicReference<Schedulers> atomicReference = INSTANCE;
            Schedulers current = atomicReference.get();
            if (current != null) {
                return current;
            }
            Schedulers current2 = new Schedulers();
            if (atomicReference.compareAndSet(null, current2)) {
                return current2;
            }
            current2.shutdownInstance();
        }
    }

    private Schedulers() {
        RxJavaSchedulersHook hook = RxJavaPlugins.getInstance().getSchedulersHook();
        Scheduler c = hook.getComputationScheduler();
        if (c != null) {
            this.computationScheduler = c;
        } else {
            this.computationScheduler = RxJavaSchedulersHook.createComputationScheduler();
        }
        Scheduler io2 = hook.getIOScheduler();
        if (io2 != null) {
            this.ioScheduler = io2;
        } else {
            this.ioScheduler = RxJavaSchedulersHook.createIoScheduler();
        }
        Scheduler nt = hook.getNewThreadScheduler();
        if (nt != null) {
            this.newThreadScheduler = nt;
        } else {
            this.newThreadScheduler = RxJavaSchedulersHook.createNewThreadScheduler();
        }
    }

    public static Scheduler immediate() {
        return ImmediateScheduler.INSTANCE;
    }

    public static Scheduler trampoline() {
        return TrampolineScheduler.INSTANCE;
    }

    public static Scheduler newThread() {
        return RxJavaHooks.onNewThreadScheduler(getInstance().newThreadScheduler);
    }

    public static Scheduler computation() {
        return RxJavaHooks.onComputationScheduler(getInstance().computationScheduler);
    }

    public static Scheduler io() {
        return RxJavaHooks.onIOScheduler(getInstance().ioScheduler);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static Scheduler from(Executor executor) {
        return new ExecutorScheduler(executor);
    }

    public static void reset() {
        Schedulers s = INSTANCE.getAndSet(null);
        if (s != null) {
            s.shutdownInstance();
        }
    }

    public static void start() {
        Schedulers s = getInstance();
        s.startInstance();
        synchronized (s) {
            GenericScheduledExecutorService.INSTANCE.start();
            RxRingBuffer.SPSC_POOL.start();
            RxRingBuffer.SPMC_POOL.start();
        }
    }

    public static void shutdown() {
        Schedulers s = getInstance();
        s.shutdownInstance();
        synchronized (s) {
            GenericScheduledExecutorService.INSTANCE.shutdown();
            RxRingBuffer.SPSC_POOL.shutdown();
            RxRingBuffer.SPMC_POOL.shutdown();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void startInstance() {
        Scheduler scheduler = this.computationScheduler;
        if (scheduler instanceof SchedulerLifecycle) {
            ((SchedulerLifecycle) scheduler).start();
        }
        Scheduler scheduler2 = this.ioScheduler;
        if (scheduler2 instanceof SchedulerLifecycle) {
            ((SchedulerLifecycle) scheduler2).start();
        }
        Scheduler scheduler3 = this.newThreadScheduler;
        if (scheduler3 instanceof SchedulerLifecycle) {
            ((SchedulerLifecycle) scheduler3).start();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void shutdownInstance() {
        Scheduler scheduler = this.computationScheduler;
        if (scheduler instanceof SchedulerLifecycle) {
            ((SchedulerLifecycle) scheduler).shutdown();
        }
        Scheduler scheduler2 = this.ioScheduler;
        if (scheduler2 instanceof SchedulerLifecycle) {
            ((SchedulerLifecycle) scheduler2).shutdown();
        }
        Scheduler scheduler3 = this.newThreadScheduler;
        if (scheduler3 instanceof SchedulerLifecycle) {
            ((SchedulerLifecycle) scheduler3).shutdown();
        }
    }
}
