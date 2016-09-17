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
    public void negative(){
        setRed(255-getRed());
        setGreen(255-getGreen());
        setBlue(255-getBlue());
    }

    /**
     *
     * @return point grey scale
     */
    public void greyScale(){
        
    }

    /**
     *
     * @param factor value between 20 and 40
     * @return sepia point
     */
    public void sepia(int factor){

    }

    /**
     *
     * @param fade fade container
     * @return point with fade
     */
    public void fadeColor(Fade fade){

    }
}
