package tests;

import org.junit.Test;
import transformation.point.Fade;
import transformation.point.RGBPoint;

import java.awt.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by moles on 2016-09-17.
 * @author moles
 */
public class RGBPointTest {
    @Test
    public void negative_base_grayScalePoint() throws Exception {
        RGBPoint negative=new RGBPoint(Color.BLACK);
        negative.negative();
        assertEquals(Color.WHITE,negative.getColor());
    }

    @Test
    public void greyScale() throws Exception {
        RGBPoint grey = new RGBPoint(105, 105, 105);
        RGBPoint rgbPoint = new RGBPoint(15, 100, 200);
        rgbPoint.greyScale();
        assertEquals(grey, rgbPoint);

    }

    @Test
    public void sepia() throws Exception {
        RGBPoint sepia = new RGBPoint(135, 120, 105);
        RGBPoint rgbPoint = new RGBPoint(15, 100, 200);
        rgbPoint.sepia(15);
        assertEquals(sepia, rgbPoint);
    }

    @Test
    public void fadeColor() throws Exception {
        RGBPoint rgbPoint = new RGBPoint(15, 100, 200);
        rgbPoint.fadeColor(new Fade(true, true, false));
        RGBPoint fade = new RGBPoint(0, 0, 200);
        assertEquals(fade, rgbPoint);

    }

}