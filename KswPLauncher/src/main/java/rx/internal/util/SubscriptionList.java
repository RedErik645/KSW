package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.Subscription;
import rx.exceptions.Exceptions;

public final class SubscriptionList implements Subscription {
    private List<Subscription> subscriptions;
    private volatile boolean unsubscribed;

    public SubscriptionList() {
    }

    public SubscriptionList(Subscription... subscriptions2) {
        this.subscriptions = new LinkedList(Arrays.asList(subscriptions2));
    }

    public SubscriptionList(Subscription s) {
        LinkedList linkedList = new LinkedList();
        this.subscriptions = linkedList;
        linkedList.add(s);
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
                        List<Subscription> subs = this.subscriptions;
                        if (subs == null) {
                            subs = new LinkedList();
                            this.subscriptions = subs;
                        }
                        subs.add(s);
                        return;
                    }
                }
            }
            s.unsubscribe();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
        if (r2 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
        r4.unsubscribe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void remove(rx.Subscription r4) {
        /*
            r3 = this;
            boolean r0 = r3.unsubscribed
            if (r0 != 0) goto L_0x0020
            r0 = 0
            monitor-enter(r3)
            java.util.List<rx.Subscription> r1 = r3.subscriptions     // Catch:{ all -> 0x001d }
            boolean r2 = r3.unsubscribed     // Catch:{ all -> 0x001d }
            if (r2 != 0) goto L_0x001b
            if (r1 != 0) goto L_0x000f
            goto L_0x001b
        L_0x000f:
            boolean r2 = r1.remove(r4)     // Catch:{ all -> 0x001d }
            r0 = r2
            monitor-exit(r3)     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x0020
            r4.unsubscribe()
            goto L_0x0020
        L_0x001b:
            monitor-exit(r3)
            return
        L_0x001d:
            r1 = move-exception
            monitor-exit(r3)
            throw r1
        L_0x0020:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.util.SubscriptionList.remove(rx.Subscription):void");
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        Throwable th;
        if (!this.unsubscribed) {
            synchronized (this) {
                try {
                    if (!this.unsubscribed) {
                        this.unsubscribed = true;
                        List<Subscription> list = this.subscriptions;
                        try {
                            this.subscriptions = null;
                            unsubscribeFromAll(list);
                        } catch (Throwable th2) {
                            th = th2;
                            while (true) {
                                try {
                                    break;
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    while (true) {
                        break;
                    }
                    throw th;
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

    public void clear() {
        Throwable th;
        if (!this.unsubscribed) {
            synchronized (this) {
                try {
                    List<Subscription> list = this.subscriptions;
                    try {
                        this.subscriptions = null;
                        unsubscribeFromAll(list);
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    throw th;
                }
            }
        }
    }

    public boolean hasSubscriptions() {
        List<Subscription> list;
        boolean z = false;
        if (this.unsubscribed) {
            return false;
        }
        synchronized (this) {
            if (!this.unsubscribed && (list = this.subscriptions) != null && !list.isEmpty()) {
                z = true;
            }
        }
        return z;
    }
}
