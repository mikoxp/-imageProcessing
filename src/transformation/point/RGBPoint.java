package transformation.point;

import image_data.RGB;

import java.awt.*;

/**
 * @author moles
 */
public class RGBPoint extends RGB {
    /**
     * @param color color
     */
    public RGBPoint(Color color) {
        super(color);
    }

    /**
     * @param colorNumber color number
     */
    public RGBPoint(int colorNumber) {
        super(colorNumber);
    }

    /**
     *
     * @return point negative
     */
    public RGB negative(){
        return this;
    }

    /**
     *
     * @return point grey scale
     */
    public RGB greyScale(){
        return this;
    }

    /**
     *
     * @param factor value between 20 and 40
     * @return sepia point
     */
    public RGB sepia(int factor){
        return this;
    }

    /**
     *
     * @param fade fade container
     * @return point with fade
     */
    public RGB fadeColor(Fade fade){
        return this;
    }
}
