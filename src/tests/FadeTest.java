package tests;

import org.junit.Test;
import transformation.point.Fade;

import static org.junit.Assert.*;

/**
 * Created by moles on 2016-09-17.
 * @author moles
 */
public class FadeTest {
    @Test
    public void constructor_defaultValue_allFalse(){
        Fade f1=new Fade();
        Fade f2=new Fade(false,false,false);
        assertEquals(f2,f1);
    }

}