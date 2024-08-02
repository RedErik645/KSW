package rx.schedulers;

public final class Timestamped<T> {
    private final long timestampMillis;
    private final T value;

    public Timestamped(long timestampMillis2, T value2) {
        this.value = value2;
        this.timestampMillis = timestampMillis2;
    }

    public long getTimestampMillis() {
        return this.timestampMillis;
    }

    public T getValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Timestamped)) {
            return false;
        }
        Timestamped<?> other = (Timestamped) obj;
        if (this.timestampMillis != other.timestampMillis) {
            return false;
        }
        T t = this.value;
        T t2 = other.value;
        if (t == t2) {
            return true;
        }
        if (t == null || !t.equals(t2)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.timestampMillis;
        int result = 31 * ((31 * 1) + ((int) (j ^ (j >>> 32))));
        T t = this.value;
        return result + (t == null ? 0 : t.hashCode());
    }

    public String toString() {
        return String.format("Timestamped(timestampMillis = %d, value = %s)", Long.valueOf(this.timestampMillis), this.value.toString());
    }
}
