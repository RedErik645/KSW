package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.AssemblyStackTraceException;

public final class OnSubscribeOnAssembly<T> implements Observable.OnSubscribe<T> {
    public static volatile boolean fullStackTrace;
    final Observable.OnSubscribe<T> source;
    final String stacktrace = createStacktrace();

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeOnAssembly(Observable.OnSubscribe<T> source2) {
        this.source = source2;
    }

    static String createStacktrace() {
        StackTraceElement[] stes = Thread.currentThread().getStackTrace();
        StringBuilder sb = new StringBuilder("Assembly trace:");
        for (StackTraceElement e : stes) {
            String row = e.toString();
            if (fullStackTrace || (e.getLineNumber() > 1 && !row.contains("RxJavaHooks.") && !row.contains("OnSubscribeOnAssembly") && !row.contains(".junit.runner") && !row.contains(".junit4.runner") && !row.contains(".junit.internal") && !row.contains("sun.reflect") && !row.contains("java.lang.Thread.") && !row.contains("ThreadPoolExecutor") && !row.contains("org.apache.catalina.") && !row.contains("org.apache.tomcat."))) {
                sb.append("\n at ").append(row);
            }
        }
        return sb.append("\nOriginal exception:").toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: rx.Observable$OnSubscribe<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public void call(Subscriber<? super T> t) {
        this.source.call(new OnAssemblySubscriber(t, this.stacktrace));
    }

    /* access modifiers changed from: package-private */
    public static final class OnAssemblySubscriber<T> extends Subscriber<T> {
        final Subscriber<? super T> actual;
        final String stacktrace;

        public OnAssemblySubscriber(Subscriber<? super T> actual2, String stacktrace2) {
            super(actual2);
            this.actual = actual2;
            this.stacktrace = stacktrace2;
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.actual.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable e) {
            new AssemblyStackTraceException(this.stacktrace).attachTo(e);
            this.actual.onError(e);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.actual.onNext(t);
        }
    }
}
