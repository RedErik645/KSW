package rx.subscriptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import rx.Subscription;
import rx.exceptions.Exceptions;

public final class CompositeSubscription implements Subscription {
    private Set<Subscription> subscriptions;
    private volatile boolean unsubscribed;

    public CompositeSubscription() {
    }

    public CompositeSubscription(Subscription... subscriptions2) {
        this.subscriptions = new HashSet(Arrays.asList(subscriptions2));
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.unsubscribed;
    }

    public void add(Subscription s) {
        if (!s.isUnsubscribed()) {
            if (!this.unsubscribed) {
                synchronized (this) {
                    if (!this.unsubscribed) {
                        if (this.subscriptions == null) {
                            this.subscriptions = new HashSet(4);
                        }
                        this.subscriptions.add(s);
                        return;
                    }
                }
            }
            s.unsubscribe();
        }
    }

    public void addAll(Subscription... subscriptions2) {
        if (!this.unsubscribed) {
            synchronized (this) {
                if (!this.unsubscribed) {
                    if (this.subscriptions == null) {
                        this.subscriptions = new HashSet(subscriptions2.length);
                    }
                    for (Subscription s : subscriptions2) {
                        if (!s.isUnsubscribed()) {
                            this.subscriptions.add(s);
                        }
                    }
                    return;
                }
            }
        }
        for (Subscription s2 : subscriptions2) {
            s2.unsubscribe();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0015, code lost:
        if (r1 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        r3.unsubscribe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void remove(rx.Subscription r3) {
        /*
            r2 = this;
            boolean r0 = r2.unsubscribed
            if (r0 != 0) goto L_0x0020
            r0 = 0
            monitor-enter(r2)
            boolean r1 = r2.unsubscribed     // Catch:{ all -> 0x001d }
            if (r1 != 0) goto L_0x001b
            java.util.Set<rx.Subscription> r1 = r2.subscriptions     // Catch:{ all -> 0x001d }
            if (r1 != 0) goto L_0x000f
            goto L_0x001b
        L_0x000f:
            boolean r1 = r1.remove(r3)     // Catch:{ all -> 0x001d }
            r0 = r1
            monitor-exit(r2)     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x0020
            r3.unsubscribe()
            goto L_0x0020
        L_0x001b:
            monitor-exit(r2)
            return
        L_0x001d:
            r1 = move-exception
            monitor-exit(r2)
            throw r1
        L_0x0020:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.subscriptions.CompositeSubscription.remove(rx.Subscription):void");
    }

    public void clear() {
        if (!this.unsubscribed) {
            synchronized (this) {
                if (!this.unsubscribed) {
                    Collection<Subscription> unsubscribe = this.subscriptions;
                    if (unsubscribe != null) {
                        this.subscriptions = null;
                        unsubscribeFromAll(unsubscribe);
                    }
                }
            }
        }
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        if (!this.unsubscribed) {
            synchronized (this) {
                if (!this.unsubscribed) {
                    this.unsubscribed = true;
                    Collection<Subscription> unsubscribe = this.subscriptions;
                    this.subscriptions = null;
                    unsubscribeFromAll(unsubscribe);
                }
            }
        }
    }

    private static void unsubscribeFromAll(Collection<Subscription> subscriptions2) {
        if (subscriptions2 != null) {
            List<Throwable> es = null;
            for (Subscription s : subscriptions2) {
                try {
                    s.unsubscribe();
                } catch (Throwable e) {
                    if (es == null) {
                        es = new ArrayList<>();
                    }
                    es.add(e);
                }
            }
            Exceptions.throwIfAny(es);
        }
    }

    public boolean hasSubscriptions() {
        Set<Subscription> set;
        boolean z = false;
        if (this.unsubscribed) {
            return false;
        }
        synchronized (this) {
            if (!this.unsubscribed && (set = this.subscriptions) != null && !set.isEmpty()) {
                z = true;
            }
        }
        return z;
    }
}
