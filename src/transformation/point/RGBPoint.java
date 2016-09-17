package transformation.point;

import image_data.RGB;

import java.awt.*;

/**
 * @author moles
 */
public class RGBPoint extends RGB {
    /**
     * @param red   red 0..255
     * @param green green 0..255
     * @param blue  blue 0..255
     */
    public RGBPoint(int red, int green, int blue) {
        super(red, green, blue);
    }

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
        int r=getRed();
        int b=getBlue();
        int g=getGreen();
        setRed(255-r);
        setGreen(255-g);
        setBlue(255-b);
    }

    /**
     *
     * @return point grey scale
     */
    public void greyScale(){
        int sum=(getRed()+getGreen()+getBlue())/3;
        setRed(sum);
        setGreen(sum);
        setBlue(sum);
    }

    /**
     *
     * @param factor value between 20 and 40
     * @return sepia point
     */
    public void sepia(int factor){
        greyScale();
        int r=getRed()+2*factor;
        int g=getGreen()+factor;
        if(r>255){
            r=255;
        }
        if(g>255){
            g=255;
        }
        setRed(r);
        setGreen(g);
    }

    /**
     *
     * @param fade fade container
     * @return point with fade
     */
    public void fadeColor(Fade fade){
        if(fade.isRed()){
            setRed(0);
        }
        if(fade.isGreen()){
            setGreen(0);
        }
        if(fade.isBlue()){
            setBlue(0);
        }

    }
}
