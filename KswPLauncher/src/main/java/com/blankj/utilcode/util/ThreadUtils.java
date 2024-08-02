package com.blankj.utilcode.util;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.provider.FontsContractCompat;
import android.util.Log;
import java.lang.Thread;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class ThreadUtils {
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final Handler HANDLER = new Handler(Looper.getMainLooper());
    private static final Map<Task, ExecutorService> TASK_POOL_MAP = new ConcurrentHashMap();
    private static final Timer TIMER = new Timer();
    private static final byte TYPE_CACHED = -2;
    private static final byte TYPE_CPU = -8;
    private static final byte TYPE_IO = -4;
    private static final Map<Integer, Map<Integer, ExecutorService>> TYPE_PRIORITY_POOLS = new HashMap();
    private static final byte TYPE_SINGLE = -1;
    private static Executor sDeliver;

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static Handler getMainHandler() {
        return HANDLER;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            HANDLER.post(runnable);
        }
    }

    public static void runOnUiThreadDelayed(Runnable runnable, long delayMillis) {
        HANDLER.postDelayed(runnable, delayMillis);
    }

    public static ExecutorService getFixedPool(int size) {
        return getPoolByTypeAndPriority(size);
    }

    public static ExecutorService getFixedPool(int size, int priority) {
        return getPoolByTypeAndPriority(size, priority);
    }

    public static ExecutorService getSinglePool() {
        return getPoolByTypeAndPriority(-1);
    }

    public static ExecutorService getSinglePool(int priority) {
        return getPoolByTypeAndPriority(-1, priority);
    }

    public static ExecutorService getCachedPool() {
        return getPoolByTypeAndPriority(-2);
    }

    public static ExecutorService getCachedPool(int priority) {
        return getPoolByTypeAndPriority(-2, priority);
    }

    public static ExecutorService getIoPool() {
        return getPoolByTypeAndPriority(-4);
    }

    public static ExecutorService getIoPool(int priority) {
        return getPoolByTypeAndPriority(-4, priority);
    }

    public static ExecutorService getCpuPool() {
        return getPoolByTypeAndPriority(-8);
    }

    public static ExecutorService getCpuPool(int priority) {
        return getPoolByTypeAndPriority(-8, priority);
    }

    public static <T> void executeByFixed(int size, Task<T> task) {
        execute(getPoolByTypeAndPriority(size), task);
    }

    public static <T> void executeByFixed(int size, Task<T> task, int priority) {
        execute(getPoolByTypeAndPriority(size, priority), task);
    }

    public static <T> void executeByFixedWithDelay(int size, Task<T> task, long delay, TimeUnit unit) {
        executeWithDelay(getPoolByTypeAndPriority(size), task, delay, unit);
    }

    public static <T> void executeByFixedWithDelay(int size, Task<T> task, long delay, TimeUnit unit, int priority) {
        executeWithDelay(getPoolByTypeAndPriority(size, priority), task, delay, unit);
    }

    public static <T> void executeByFixedAtFixRate(int size, Task<T> task, long period, TimeUnit unit) {
        executeAtFixedRate(getPoolByTypeAndPriority(size), task, 0, period, unit);
    }

    public static <T> void executeByFixedAtFixRate(int size, Task<T> task, long period, TimeUnit unit, int priority) {
        executeAtFixedRate(getPoolByTypeAndPriority(size, priority), task, 0, period, unit);
    }

    public static <T> void executeByFixedAtFixRate(int size, Task<T> task, long initialDelay, long period, TimeUnit unit) {
        executeAtFixedRate(getPoolByTypeAndPriority(size), task, initialDelay, period, unit);
    }

    public static <T> void executeByFixedAtFixRate(int size, Task<T> task, long initialDelay, long period, TimeUnit unit, int priority) {
        executeAtFixedRate(getPoolByTypeAndPriority(size, priority), task, initialDelay, period, unit);
    }

    public static <T> void executeBySingle(Task<T> task) {
        execute(getPoolByTypeAndPriority(-1), task);
    }

    public static <T> void executeBySingle(Task<T> task, int priority) {
        execute(getPoolByTypeAndPriority(-1, priority), task);
    }

    public static <T> void executeBySingleWithDelay(Task<T> task, long delay, TimeUnit unit) {
        executeWithDelay(getPoolByTypeAndPriority(-1), task, delay, unit);
    }

    public static <T> void executeBySingleWithDelay(Task<T> task, long delay, TimeUnit unit, int priority) {
        executeWithDelay(getPoolByTypeAndPriority(-1, priority), task, delay, unit);
    }

    public static <T> void executeBySingleAtFixRate(Task<T> task, long period, TimeUnit unit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-1), task, 0, period, unit);
    }

    public static <T> void executeBySingleAtFixRate(Task<T> task, long period, TimeUnit unit, int priority) {
        executeAtFixedRate(getPoolByTypeAndPriority(-1, priority), task, 0, period, unit);
    }

    public static <T> void executeBySingleAtFixRate(Task<T> task, long initialDelay, long period, TimeUnit unit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-1), task, initialDelay, period, unit);
    }

    public static <T> void executeBySingleAtFixRate(Task<T> task, long initialDelay, long period, TimeUnit unit, int priority) {
        executeAtFixedRate(getPoolByTypeAndPriority(-1, priority), task, initialDelay, period, unit);
    }

    public static <T> void executeByCached(Task<T> task) {
        execute(getPoolByTypeAndPriority(-2), task);
    }

    public static <T> void executeByCached(Task<T> task, int priority) {
        execute(getPoolByTypeAndPriority(-2, priority), task);
    }

    public static <T> void executeByCachedWithDelay(Task<T> task, long delay, TimeUnit unit) {
        executeWithDelay(getPoolByTypeAndPriority(-2), task, delay, unit);
    }

    public static <T> void executeByCachedWithDelay(Task<T> task, long delay, TimeUnit unit, int priority) {
        executeWithDelay(getPoolByTypeAndPriority(-2, priority), task, delay, unit);
    }

    public static <T> void executeByCachedAtFixRate(Task<T> task, long period, TimeUnit unit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-2), task, 0, period, unit);
    }

    public static <T> void executeByCachedAtFixRate(Task<T> task, long period, TimeUnit unit, int priority) {
        executeAtFixedRate(getPoolByTypeAndPriority(-2, priority), task, 0, period, unit);
    }

    public static <T> void executeByCachedAtFixRate(Task<T> task, long initialDelay, long period, TimeUnit unit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-2), task, initialDelay, period, unit);
    }

    public static <T> void executeByCachedAtFixRate(Task<T> task, long initialDelay, long period, TimeUnit unit, int priority) {
        executeAtFixedRate(getPoolByTypeAndPriority(-2, priority), task, initialDelay, period, unit);
    }

    public static <T> void executeByIo(Task<T> task) {
        execute(getPoolByTypeAndPriority(-4), task);
    }

    public static <T> void executeByIo(Task<T> task, int priority) {
        execute(getPoolByTypeAndPriority(-4, priority), task);
    }

    public static <T> void executeByIoWithDelay(Task<T> task, long delay, TimeUnit unit) {
        executeWithDelay(getPoolByTypeAndPriority(-4), task, delay, unit);
    }

    public static <T> void executeByIoWithDelay(Task<T> task, long delay, TimeUnit unit, int priority) {
        executeWithDelay(getPoolByTypeAndPriority(-4, priority), task, delay, unit);
    }

    public static <T> void executeByIoAtFixRate(Task<T> task, long period, TimeUnit unit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-4), task, 0, period, unit);
    }

    public static <T> void executeByIoAtFixRate(Task<T> task, long period, TimeUnit unit, int priority) {
        executeAtFixedRate(getPoolByTypeAndPriority(-4, priority), task, 0, period, unit);
    }

    public static <T> void executeByIoAtFixRate(Task<T> task, long initialDelay, long period, TimeUnit unit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-4), task, initialDelay, period, unit);
    }

    public static <T> void executeByIoAtFixRate(Task<T> task, long initialDelay, long period, TimeUnit unit, int priority) {
        executeAtFixedRate(getPoolByTypeAndPriority(-4, priority), task, initialDelay, period, unit);
    }

    public static <T> void executeByCpu(Task<T> task) {
        execute(getPoolByTypeAndPriority(-8), task);
    }

    public static <T> void executeByCpu(Task<T> task, int priority) {
        execute(getPoolByTypeAndPriority(-8, priority), task);
    }

    public static <T> void executeByCpuWithDelay(Task<T> task, long delay, TimeUnit unit) {
        executeWithDelay(getPoolByTypeAndPriority(-8), task, delay, unit);
    }

    public static <T> void executeByCpuWithDelay(Task<T> task, long delay, TimeUnit unit, int priority) {
        executeWithDelay(getPoolByTypeAndPriority(-8, priority), task, delay, unit);
    }

    public static <T> void executeByCpuAtFixRate(Task<T> task, long period, TimeUnit unit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-8), task, 0, period, unit);
    }

    public static <T> void executeByCpuAtFixRate(Task<T> task, long period, TimeUnit unit, int priority) {
        executeAtFixedRate(getPoolByTypeAndPriority(-8, priority), task, 0, period, unit);
    }

    public static <T> void executeByCpuAtFixRate(Task<T> task, long initialDelay, long period, TimeUnit unit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-8), task, initialDelay, period, unit);
    }

    public static <T> void executeByCpuAtFixRate(Task<T> task, long initialDelay, long period, TimeUnit unit, int priority) {
        executeAtFixedRate(getPoolByTypeAndPriority(-8, priority), task, initialDelay, period, unit);
    }

    public static <T> void executeByCustom(ExecutorService pool, Task<T> task) {
        execute(pool, task);
    }

    public static <T> void executeByCustomWithDelay(ExecutorService pool, Task<T> task, long delay, TimeUnit unit) {
        executeWithDelay(pool, task, delay, unit);
    }

    public static <T> void executeByCustomAtFixRate(ExecutorService pool, Task<T> task, long period, TimeUnit unit) {
        executeAtFixedRate(pool, task, 0, period, unit);
    }

    public static <T> void executeByCustomAtFixRate(ExecutorService pool, Task<T> task, long initialDelay, long period, TimeUnit unit) {
        executeAtFixedRate(pool, task, initialDelay, period, unit);
    }

    public static void cancel(Task task) {
        if (task != null) {
            task.cancel();
        }
    }

    public static void cancel(Task... tasks) {
        if (!(tasks == null || tasks.length == 0)) {
            for (Task task : tasks) {
                if (task != null) {
                    task.cancel();
                }
            }
        }
    }

    public static void cancel(List<Task> tasks) {
        if (!(tasks == null || tasks.size() == 0)) {
            for (Task task : tasks) {
                if (task != null) {
                    task.cancel();
                }
            }
        }
    }

    public static void cancel(ExecutorService executorService) {
        if (executorService instanceof ThreadPoolExecutor4Util) {
            for (Map.Entry<Task, ExecutorService> taskTaskInfoEntry : TASK_POOL_MAP.entrySet()) {
                if (taskTaskInfoEntry.getValue() == executorService) {
                    cancel(taskTaskInfoEntry.getKey());
                }
            }
            return;
        }
        Log.e("ThreadUtils", "The executorService is not ThreadUtils's pool.");
    }

    public static void setDeliver(Executor deliver) {
        sDeliver = deliver;
    }

    private static <T> void execute(ExecutorService pool, Task<T> task) {
        execute(pool, task, 0, 0, null);
    }

    private static <T> void executeWithDelay(ExecutorService pool, Task<T> task, long delay, TimeUnit unit) {
        execute(pool, task, delay, 0, unit);
    }

    private static <T> void executeAtFixedRate(ExecutorService pool, Task<T> task, long delay, long period, TimeUnit unit) {
        execute(pool, task, delay, period, unit);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        if (r11 != 0) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
        if (r9 != 0) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0020, code lost:
        r7.execute(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
        com.blankj.utilcode.util.ThreadUtils.TIMER.schedule(new com.blankj.utilcode.util.ThreadUtils.AnonymousClass1(), r13.toMillis(r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        r8.setSchedule(true);
        com.blankj.utilcode.util.ThreadUtils.TIMER.scheduleAtFixedRate(new com.blankj.utilcode.util.ThreadUtils.AnonymousClass2(), r13.toMillis(r9), r13.toMillis(r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> void execute(final java.util.concurrent.ExecutorService r7, final com.blankj.utilcode.util.ThreadUtils.Task<T> r8, long r9, long r11, java.util.concurrent.TimeUnit r13) {
        /*
            java.util.Map<com.blankj.utilcode.util.ThreadUtils$Task, java.util.concurrent.ExecutorService> r0 = com.blankj.utilcode.util.ThreadUtils.TASK_POOL_MAP
            monitor-enter(r0)
            java.lang.Object r1 = r0.get(r8)     // Catch:{ all -> 0x004a }
            if (r1 == 0) goto L_0x0012
            java.lang.String r1 = "ThreadUtils"
            java.lang.String r2 = "Task can only be executed once."
            android.util.Log.e(r1, r2)     // Catch:{ all -> 0x004a }
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            return
        L_0x0012:
            r0.put(r8, r7)     // Catch:{ all -> 0x004a }
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            r0 = 0
            int r2 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r2 != 0) goto L_0x0033
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 != 0) goto L_0x0024
            r7.execute(r8)
            goto L_0x0049
        L_0x0024:
            com.blankj.utilcode.util.ThreadUtils$1 r0 = new com.blankj.utilcode.util.ThreadUtils$1
            r0.<init>(r7, r8)
            java.util.Timer r1 = com.blankj.utilcode.util.ThreadUtils.TIMER
            long r2 = r13.toMillis(r9)
            r1.schedule(r0, r2)
            goto L_0x0049
        L_0x0033:
            r0 = 1
            com.blankj.utilcode.util.ThreadUtils.Task.access$000(r8, r0)
            com.blankj.utilcode.util.ThreadUtils$2 r2 = new com.blankj.utilcode.util.ThreadUtils$2
            r2.<init>(r7, r8)
            java.util.Timer r1 = com.blankj.utilcode.util.ThreadUtils.TIMER
            long r3 = r13.toMillis(r9)
            long r5 = r13.toMillis(r11)
            r1.scheduleAtFixedRate(r2, r3, r5)
        L_0x0049:
            return
        L_0x004a:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.ThreadUtils.execute(java.util.concurrent.ExecutorService, com.blankj.utilcode.util.ThreadUtils$Task, long, long, java.util.concurrent.TimeUnit):void");
    }

    private static ExecutorService getPoolByTypeAndPriority(int type) {
        return getPoolByTypeAndPriority(type, 5);
    }

    private static ExecutorService getPoolByTypeAndPriority(int type, int priority) {
        ExecutorService pool;
        Map<Integer, Map<Integer, ExecutorService>> map = TYPE_PRIORITY_POOLS;
        synchronized (map) {
            Map<Integer, ExecutorService> priorityPools = map.get(Integer.valueOf(type));
            if (priorityPools == null) {
                Map<Integer, ExecutorService> priorityPools2 = new ConcurrentHashMap<>();
                pool = ThreadPoolExecutor4Util.createPool(type, priority);
                priorityPools2.put(Integer.valueOf(priority), pool);
                map.put(Integer.valueOf(type), priorityPools2);
            } else {
                pool = priorityPools.get(Integer.valueOf(priority));
                if (pool == null) {
                    pool = ThreadPoolExecutor4Util.createPool(type, priority);
                    priorityPools.put(Integer.valueOf(priority), pool);
                }
            }
        }
        return pool;
    }

    /* access modifiers changed from: package-private */
    public static final class ThreadPoolExecutor4Util extends ThreadPoolExecutor {
        private final AtomicInteger mSubmittedCount = new AtomicInteger();
        private LinkedBlockingQueue4Util mWorkQueue;

        /* access modifiers changed from: private */
        public static ExecutorService createPool(int type, int priority) {
            switch (type) {
                case -8:
                    return new ThreadPoolExecutor4Util(ThreadUtils.CPU_COUNT + 1, (ThreadUtils.CPU_COUNT * 2) + 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(true), new UtilsThreadFactory("cpu", priority));
                case FontsContractCompat.FontRequestCallback.FAIL_REASON_SECURITY_VIOLATION:
                    return new ThreadPoolExecutor4Util((ThreadUtils.CPU_COUNT * 2) + 1, (ThreadUtils.CPU_COUNT * 2) + 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("io", priority));
                case -2:
                    return new ThreadPoolExecutor4Util(0, 128, 60, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(true), new UtilsThreadFactory("cached", priority));
                case -1:
                    return new ThreadPoolExecutor4Util(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("single", priority));
                default:
                    return new ThreadPoolExecutor4Util(type, type, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("fixed(" + type + ")", priority));
            }
        }

        ThreadPoolExecutor4Util(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, LinkedBlockingQueue4Util workQueue, ThreadFactory threadFactory) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
            workQueue.mPool = this;
            this.mWorkQueue = workQueue;
        }

        private int getSubmittedCount() {
            return this.mSubmittedCount.get();
        }

        /* access modifiers changed from: protected */
        public void afterExecute(Runnable r, Throwable t) {
            this.mSubmittedCount.decrementAndGet();
            super.afterExecute(r, t);
        }

        public void execute(Runnable command) {
            if (command == null) {
                throw new NullPointerException("Argument 'command' of type Runnable (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
            } else if (!isShutdown()) {
                this.mSubmittedCount.incrementAndGet();
                try {
                    super.execute(command);
                } catch (RejectedExecutionException e) {
                    Log.e("ThreadUtils", "This will not happen!");
                    this.mWorkQueue.offer(command);
                } catch (Throwable th) {
                    this.mSubmittedCount.decrementAndGet();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final class LinkedBlockingQueue4Util extends LinkedBlockingQueue<Runnable> {
        private int mCapacity = Integer.MAX_VALUE;
        private volatile ThreadPoolExecutor4Util mPool;

        LinkedBlockingQueue4Util() {
        }

        LinkedBlockingQueue4Util(boolean isAddSubThreadFirstThenAddQueue) {
            if (isAddSubThreadFirstThenAddQueue) {
                this.mCapacity = 0;
            }
        }

        LinkedBlockingQueue4Util(int capacity) {
            this.mCapacity = capacity;
        }

        public boolean offer(Runnable runnable) {
            if (runnable == null) {
                throw new NullPointerException("Argument 'runnable' of type Runnable (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
            } else if (this.mCapacity > size() || this.mPool == null || this.mPool.getPoolSize() >= this.mPool.getMaximumPoolSize()) {
                return super.offer((Object) runnable);
            } else {
                return false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class UtilsThreadFactory extends AtomicLong implements ThreadFactory {
        private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
        private static final long serialVersionUID = -9209200509960368598L;
        private final boolean isDaemon;
        private final String namePrefix;
        private final int priority;

        UtilsThreadFactory(String prefix, int priority2) {
            this(prefix, priority2, false);
        }

        UtilsThreadFactory(String prefix, int priority2, boolean isDaemon2) {
            this.namePrefix = prefix + "-pool-" + POOL_NUMBER.getAndIncrement() + "-thread-";
            this.priority = priority2;
            this.isDaemon = isDaemon2;
        }

        public Thread newThread(Runnable r) {
            if (r != null) {
                Thread t = new Thread(r, this.namePrefix + getAndIncrement()) {
                    /* class com.blankj.utilcode.util.ThreadUtils.UtilsThreadFactory.AnonymousClass1 */

                    public void run() {
                        try {
                            super.run();
                        } catch (Throwable t) {
                            Log.e("ThreadUtils", "Request threw uncaught throwable", t);
                        }
                    }
                };
                t.setDaemon(this.isDaemon);
                t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                    /* class com.blankj.utilcode.util.ThreadUtils.UtilsThreadFactory.AnonymousClass2 */

                    public void uncaughtException(Thread t, Throwable e) {
                        System.out.println(e);
                    }
                });
                t.setPriority(this.priority);
                return t;
            }
            throw new NullPointerException("Argument 'r' of type Runnable (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static abstract class SimpleTask<T> extends Task<T> {
        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onCancel() {
            Log.e("ThreadUtils", "onCancel: " + Thread.currentThread());
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onFail(Throwable t) {
            Log.e("ThreadUtils", "onFail: ", t);
        }
    }

    public static abstract class Task<T> implements Runnable {
        private static final int CANCELLED = 4;
        private static final int COMPLETING = 3;
        private static final int EXCEPTIONAL = 2;
        private static final int INTERRUPTED = 5;
        private static final int NEW = 0;
        private static final int RUNNING = 1;
        private static final int TIMEOUT = 6;
        private Executor deliver;
        private volatile boolean isSchedule;
        private OnTimeoutListener mTimeoutListener;
        private long mTimeoutMillis;
        private Timer mTimer;
        private volatile Thread runner;
        private final AtomicInteger state = new AtomicInteger(0);

        public interface OnTimeoutListener {
            void onTimeout();
        }

        public abstract T doInBackground() throws Throwable;

        public abstract void onCancel();

        public abstract void onFail(Throwable th);

        public abstract void onSuccess(T t);

        public void run() {
            if (this.isSchedule) {
                if (this.runner == null) {
                    if (this.state.compareAndSet(0, 1)) {
                        this.runner = Thread.currentThread();
                        if (this.mTimeoutListener != null) {
                            Log.w("ThreadUtils", "Scheduled task doesn't support timeout.");
                        }
                    } else {
                        return;
                    }
                } else if (this.state.get() != 1) {
                    return;
                }
            } else if (this.state.compareAndSet(0, 1)) {
                this.runner = Thread.currentThread();
                if (this.mTimeoutListener != null) {
                    Timer timer = new Timer();
                    this.mTimer = timer;
                    timer.schedule(new TimerTask() {
                        /* class com.blankj.utilcode.util.ThreadUtils.Task.AnonymousClass1 */

                        public void run() {
                            if (!Task.this.isDone() && Task.this.mTimeoutListener != null) {
                                Task.this.timeout();
                                Task.this.mTimeoutListener.onTimeout();
                            }
                        }
                    }, this.mTimeoutMillis);
                }
            } else {
                return;
            }
            try {
                final T result = doInBackground();
                if (this.isSchedule) {
                    if (this.state.get() == 1) {
                        getDeliver().execute(new Runnable() {
                            /* class com.blankj.utilcode.util.ThreadUtils.Task.AnonymousClass2 */

                            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.blankj.utilcode.util.ThreadUtils$Task */
                            /* JADX WARN: Multi-variable type inference failed */
                            public void run() {
                                Task.this.onSuccess(result);
                            }
                        });
                    }
                } else if (this.state.compareAndSet(1, 3)) {
                    getDeliver().execute(new Runnable() {
                        /* class com.blankj.utilcode.util.ThreadUtils.Task.AnonymousClass3 */

                        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.blankj.utilcode.util.ThreadUtils$Task */
                        /* JADX WARN: Multi-variable type inference failed */
                        public void run() {
                            Task.this.onSuccess(result);
                            Task.this.onDone();
                        }
                    });
                }
            } catch (InterruptedException e) {
                this.state.compareAndSet(4, 5);
            } catch (Throwable throwable) {
                if (this.state.compareAndSet(1, 2)) {
                    getDeliver().execute(new Runnable() {
                        /* class com.blankj.utilcode.util.ThreadUtils.Task.AnonymousClass4 */

                        public void run() {
                            Task.this.onFail(throwable);
                            Task.this.onDone();
                        }
                    });
                }
            }
        }

        public void cancel() {
            cancel(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
            if (r3.runner == null) goto L_0x0020;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
            r3.runner.interrupt();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
            getDeliver().execute(new com.blankj.utilcode.util.ThreadUtils.Task.AnonymousClass5(r3));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
            if (r4 == false) goto L_0x0020;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void cancel(boolean r4) {
            /*
                r3 = this;
                java.util.concurrent.atomic.AtomicInteger r0 = r3.state
                monitor-enter(r0)
                java.util.concurrent.atomic.AtomicInteger r1 = r3.state     // Catch:{ all -> 0x002d }
                int r1 = r1.get()     // Catch:{ all -> 0x002d }
                r2 = 1
                if (r1 <= r2) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x002d }
                return
            L_0x000e:
                java.util.concurrent.atomic.AtomicInteger r1 = r3.state     // Catch:{ all -> 0x002d }
                r2 = 4
                r1.set(r2)     // Catch:{ all -> 0x002d }
                monitor-exit(r0)     // Catch:{ all -> 0x002d }
                if (r4 == 0) goto L_0x0020
                java.lang.Thread r0 = r3.runner
                if (r0 == 0) goto L_0x0020
                java.lang.Thread r0 = r3.runner
                r0.interrupt()
            L_0x0020:
                java.util.concurrent.Executor r0 = r3.getDeliver()
                com.blankj.utilcode.util.ThreadUtils$Task$5 r1 = new com.blankj.utilcode.util.ThreadUtils$Task$5
                r1.<init>()
                r0.execute(r1)
                return
            L_0x002d:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.ThreadUtils.Task.cancel(boolean):void");
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
            if (r3.runner == null) goto L_0x001e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
            r3.runner.interrupt();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
            onDone();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void timeout() {
            /*
                r3 = this;
                java.util.concurrent.atomic.AtomicInteger r0 = r3.state
                monitor-enter(r0)
                java.util.concurrent.atomic.AtomicInteger r1 = r3.state     // Catch:{ all -> 0x0022 }
                int r1 = r1.get()     // Catch:{ all -> 0x0022 }
                r2 = 1
                if (r1 <= r2) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x0022 }
                return
            L_0x000e:
                java.util.concurrent.atomic.AtomicInteger r1 = r3.state     // Catch:{ all -> 0x0022 }
                r2 = 6
                r1.set(r2)     // Catch:{ all -> 0x0022 }
                monitor-exit(r0)     // Catch:{ all -> 0x0022 }
                java.lang.Thread r0 = r3.runner
                if (r0 == 0) goto L_0x001e
                java.lang.Thread r0 = r3.runner
                r0.interrupt()
            L_0x001e:
                r3.onDone()
                return
            L_0x0022:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.ThreadUtils.Task.timeout():void");
        }

        public boolean isCanceled() {
            return this.state.get() >= 4;
        }

        public boolean isDone() {
            return this.state.get() > 1;
        }

        public Task<T> setDeliver(Executor deliver2) {
            this.deliver = deliver2;
            return this;
        }

        public Task<T> setTimeout(long timeoutMillis, OnTimeoutListener listener) {
            this.mTimeoutMillis = timeoutMillis;
            this.mTimeoutListener = listener;
            return this;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void setSchedule(boolean isSchedule2) {
            this.isSchedule = isSchedule2;
        }

        private Executor getDeliver() {
            Executor executor = this.deliver;
            if (executor == null) {
                return ThreadUtils.getGlobalDeliver();
            }
            return executor;
        }

        /* access modifiers changed from: protected */
        public void onDone() {
            ThreadUtils.TASK_POOL_MAP.remove(this);
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.cancel();
                this.mTimer = null;
                this.mTimeoutListener = null;
            }
        }
    }

    public static class SyncValue<T> {
        private AtomicBoolean mFlag = new AtomicBoolean();
        private CountDownLatch mLatch = new CountDownLatch(1);
        private T mValue;

        public void setValue(T value) {
            if (this.mFlag.compareAndSet(false, true)) {
                this.mValue = value;
                this.mLatch.countDown();
            }
        }

        public T getValue() {
            if (!this.mFlag.get()) {
                try {
                    this.mLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return this.mValue;
        }
    }

    /* access modifiers changed from: private */
    public static Executor getGlobalDeliver() {
        if (sDeliver == null) {
            sDeliver = new Executor() {
                /* class com.blankj.utilcode.util.ThreadUtils.AnonymousClass3 */

                public void execute(Runnable command) {
                    if (command != null) {
                        ThreadUtils.runOnUiThread(command);
                        return;
                    }
                    throw new NullPointerException("Argument 'command' of type Runnable (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
                }
            };
        }
        return sDeliver;
    }
}
