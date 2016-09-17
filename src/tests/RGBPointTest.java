package tests;

import org.junit.Test;
import transformation.point.RGBPoint;

import java.awt.*;

import static org.junit.Assert.*;

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

    }

    @Test
    public void sepia() throws Exception {

    }

    @Test
    public void fadeColor() throws Exception {

    }

}