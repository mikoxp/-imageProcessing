package transformation.context.line_filters.normalization;

/**
 * Created by moles on 20.09.2016.
 * @author moles
 */
public class NormalizerRange {
    private int min;
    private int max;

    /**
     *
     * @param min min value
     * @param max max value
     */
    public NormalizerRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public NormalizerRange() {
        this.min = 0;
        this.max = 255;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NormalizerRange)) return false;

        NormalizerRange range = (NormalizerRange) o;

        if (getMin() != range.getMin()) return false;
        return getMax() == range.getMax();

    }

    @Override
    public int hashCode() {
        int result = getMin();
        result = 31 * result + getMax();
        return result;
    }

    @Override
    public String toString() {
        return "NormalizerRange{" +
                "min=" + min +
                ", max=" + max +
                '}';
    }
}
