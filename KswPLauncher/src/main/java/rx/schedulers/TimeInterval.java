package rx.schedulers;

public class TimeInterval<T> {
    private final long intervalInMilliseconds;
    private final T value;

    public TimeInterval(long intervalInMilliseconds2, T value2) {
        this.value = value2;
        this.intervalInMilliseconds = intervalInMilliseconds2;
    }

    public long getIntervalInMilliseconds() {
        return this.intervalInMilliseconds;
    }

    public T getValue() {
        return this.value;
    }

    public int hashCode() {
        long j = this.intervalInMilliseconds;
        int result = 31 * ((31 * 1) + ((int) (j ^ (j >>> 32))));
        T t = this.value;
        return result + (t == null ? 0 : t.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TimeInterval<?> other = (TimeInterval) obj;
        if (this.intervalInMilliseconds != other.intervalInMilliseconds) {
            return false;
        }
        T t = this.value;
        if (t == null) {
            if (other.value != null) {
                return false;
            }
        } else if (!t.equals(other.value)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "TimeInterval [intervalInMilliseconds=" + this.intervalInMilliseconds + ", value=" + ((Object) this.value) + "]";
    }
}
