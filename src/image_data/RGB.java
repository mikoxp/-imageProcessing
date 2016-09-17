package image_data;

import java.awt.*;

/**
 * Created by moles on 2016-09-12.
 *
 * @author moles
 */
public class RGB {
    private int red;
    private int green;
    private int blue;

    /**
     * @param red   red
     * @param green green
     * @param blue  blue
     */
    public RGB(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    /**
     * @param color color
     */
    public RGB(Color color) {
        this.red = color.getRed();
        this.green = color.getGreen();
        this.blue = color.getBlue();
    }

    /**
     * @param colorNumber color number
     */
    public RGB(int colorNumber) {
        Color color = new Color(colorNumber);
        this.red = color.getRed();
        this.green = color.getGreen();
        this.blue = color.getBlue();
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }
}
