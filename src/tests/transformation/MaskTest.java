package tests.transformation;

import org.junit.Assert;
import org.junit.Test;
import transformation.context.line_filters.Mask;

import static org.junit.Assert.assertEquals;

/**
 * Created by moles on 19.09.2016.
 * @author moles
 */
public class MaskTest {

    @Test(expected = IllegalArgumentException.class)
    public void constructor_matrixNotSquare_IllegalArgumentException(){
        new Mask(new int[3][5]);
    }
    @Test(expected = IllegalArgumentException.class)
    public void constructor_sizeIsEven_IllegalArgumentException(){
        new Mask(new int[4][4]);
    }
    @Test
    public void getElement_Value_corectValue(){
        int[][] val=new int[5][5];
        val[3][4]=5;
        Mask mask=new Mask(val);
        assertEquals(5,mask.getElement(3,4));
    }
    @Test(expected = IllegalArgumentException.class)
    public void getElement_incoect_width_IllegalArgumentException() throws Exception {
        Mask mask=new Mask(new int[5][5]);
        mask.getElement(50,0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void getElement_incoect_height_IllegalArgumentException() throws Exception {
        Mask mask=new Mask(new int[5][5]);
        mask.getElement(0,55);
    }

    @Test
    public void getStringMask_value() {
        int[][] value = new int[3][3];
        value[0][0] = 2;
        value[2][0] = -2;
        value[0][1] = 2;
        value[1][1] = -1;
        value[2][1] = -2;
        value[1][2] = 2;
        Mask mask = new Mask(value);
        String mark = "_ 2 0 -2_ 2 -1 -2_ 0 2 0";
        Assert.assertEquals(mark, mask.getStringMask());
    }
}