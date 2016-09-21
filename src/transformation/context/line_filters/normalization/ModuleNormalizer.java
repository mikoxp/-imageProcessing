package transformation.context.line_filters.normalization;

import image_data.RGB;

import java.awt.*;

/**
 * Created by moles on 20.09.2016.
 * @author moles
 */
public class ModuleNormalizer implements Normalizer{
    private final int max=255;
    /**
     *
     */
    public ModuleNormalizer() {
    }

    /**
     * @param red   red part color before normalization
     * @param green green part color before normalization
     * @param blue  blue part color before normalization
     * @return Color after normalization
     */
    public Color normalizing(int red, int green, int blue) {
        red=Math.abs(red);
        green=Math.abs(green);
        blue=Math.abs(blue);
        if(red>max){
            red=max;
        }
        if(green>max){
            green=max;
        }
        if(blue>max){
            blue=max;
        }
        RGB rgb=new RGB(red,green,blue);
        return rgb.getColor();
    }
}
