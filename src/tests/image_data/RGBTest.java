package tests.image_data;

import image_data.RGB;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by moles on 2016-09-17.
 * @author moles
 */
public class RGBTest {

    @Test(expected = IllegalArgumentException.class)
    public void constructor_negativeValue_IllegalArgumentException() {
        new RGB(-1,1,1);
    }
    @Test(expected = NullPointerException.class)
    public void constructor_ColorIsNull_IllegalArgumentException(){
        new RGB(null);
    }
    @Test
    public void getColor_ColorParseCorect_Color(){
        Color color=Color.CYAN;
        RGB rgb=new RGB(color);
        assertEquals(color,rgb.getColor());
    }

}