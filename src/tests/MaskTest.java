package tests;

import org.junit.Test;
import transformation.context.line_filters.Mask;

import static org.junit.Assert.*;

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
}