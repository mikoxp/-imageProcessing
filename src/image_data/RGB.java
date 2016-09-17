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
     *
     */
    public RGB() {
        red = 0;
        green = 0;
        blue = 0;
    }

    /**
     * @param red   red 0..255
     * @param green green 0..255
     * @param blue  blue 0..255
     */
    public RGB(int red, int green, int blue) {
        if(red<0||green<0||blue<0){
            throw new IllegalArgumentException();
        }
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    /**
     * @param color color
     */
    public RGB(Color color) {
        this(color.getRed(),color.getGreen(),color.getBlue());
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
    public Color getColor(){
        float r=(float)red/255;
        float g=(float)green/255;
        float b=(float)blue/255;
        Color color=new Color(r,g,b);
        return color;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RGB rgb = (RGB) o;

        if (red != rgb.red) return false;
        if (green != rgb.green) return false;
        return blue == rgb.blue;

    }

    @Override
    public int hashCode() {
        int result = red;
        result = 31 * result + green;
        result = 31 * result + blue;
        return result;
    }

    @Override
    public String toString() {
        return "RGB{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                '}';
    }
}
