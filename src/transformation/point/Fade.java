package transformation.point;

/**
 * Created by moles on 2016-09-17.
 * @author moles
 */
public class Fade {
    private boolean red;
    private boolean blue;
    private boolean green;

    /**
     *
     */
    public Fade() {
        this(false,false,false);
    }

    /**
     *
     * @param red red
     * @param blue blue
     * @param green green
     */
    public Fade(boolean red, boolean green, boolean blue) {
        this.red = red;
        this.blue = blue;
        this.green = green;
    }

    public boolean isRed() {
        return red;
    }

    public void setRed(boolean red) {
        this.red = red;
    }

    public boolean isBlue() {
        return blue;
    }

    public void setBlue(boolean blue) {
        this.blue = blue;
    }

    public boolean isGreen() {
        return green;
    }

    public void setGreen(boolean green) {
        this.green = green;
    }

    @Override
    public String toString() {
        return "Fade{" +
                "red=" + red +
                ", blue=" + blue +
                ", green=" + green +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fade)) return false;

        Fade fade = (Fade) o;

        if (isRed() != fade.isRed()) return false;
        if (isBlue() != fade.isBlue()) return false;
        return isGreen() == fade.isGreen();

    }

    @Override
    public int hashCode() {
        int result = (isRed() ? 1 : 0);
        result = 31 * result + (isBlue() ? 1 : 0);
        result = 31 * result + (isGreen() ? 1 : 0);
        return result;
    }
}
