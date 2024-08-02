package rx;

import kotlin.jvm.internal.LongCompanionObject;
import rx.internal.util.SubscriptionList;

public abstract class Subscriber<T> implements Observer<T>, Subscription {
    private static final long NOT_SET = Long.MIN_VALUE;
    private Producer producer;
    private long requested;
    private final Subscriber<?> subscriber;
    private final SubscriptionList subscriptions;

    protected Subscriber() {
        this(null, false);
    }

    protected Subscriber(Subscriber<?> subscriber2) {
        this(subscriber2, true);
    }

    protected Subscriber(Subscriber<?> subscriber2, boolean shareSubscriptions) {
        this.requested = Long.MIN_VALUE;
        this.subscriber = subscriber2;
        this.subscriptions = (!shareSubscriptions || subscriber2 == null) ? new SubscriptionList() : subscriber2.subscriptions;
    }

    public final void add(Subscription s) {
        this.subscriptions.add(s);
    }

    @Override // rx.Subscription
    public final void unsubscribe() {
        this.subscriptions.unsubscribe();
    }

    @Override // rx.Subscription
    public final boolean isUnsubscribed() {
        return this.subscriptions.isUnsubscribed();
    }

    public void onStart() {
    }

    /* access modifiers changed from: protected */
    public final void request(long n) {
        if (n >= 0) {
            synchronized (this) {
                Producer producerToRequestFrom = this.producer;
                if (producerToRequestFrom != null) {
                    producerToRequestFrom.request(n);
                } else {
                    addToRequested(n);
                }
            }
        } else {
            throw new IllegalArgumentException("number requested cannot be negative: " + n);
        }
    }

    private void addToRequested(long n) {
        long j = this.requested;
        if (j == Long.MIN_VALUE) {
            this.requested = n;
            return;
        }
        long total = j + n;
        if (total < 0) {
            this.requested = LongCompanionObject.MAX_VALUE;
        } else {
            this.requested = total;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0012, code lost:
        if (r0 == false) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0014, code lost:
        r3.setProducer(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001a, code lost:
        if (r1 != Long.MIN_VALUE) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001c, code lost:
        r8.request(kotlin.jvm.internal.LongCompanionObject.MAX_VALUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
        r8.request(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProducer(rx.Producer r8) {
        /*
            r7 = this;
            r0 = 0
            monitor-enter(r7)
            long r1 = r7.requested     // Catch:{ all -> 0x002b }
            r7.producer = r8     // Catch:{ all -> 0x0029 }
            rx.Subscriber<?> r3 = r7.subscriber     // Catch:{ all -> 0x0029 }
            r4 = -9223372036854775808
            if (r3 == 0) goto L_0x0011
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0011
            r0 = 1
        L_0x0011:
            monitor-exit(r7)     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x0018
            r3.setProducer(r8)
            goto L_0x0028
        L_0x0018:
            int r3 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x0025
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r8.request(r3)
            goto L_0x0028
        L_0x0025:
            r8.request(r1)
        L_0x0028:
            return
        L_0x0029:
            r3 = move-exception
            goto L_0x002e
        L_0x002b:
            r3 = move-exception
            r1 = 0
        L_0x002e:
            monitor-exit(r7)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.Subscriber.setProducer(rx.Producer):void");
    }
}
