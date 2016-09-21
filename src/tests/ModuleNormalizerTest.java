package tests;

import image_data.RGB;
import org.junit.Test;
import transformation.context.line_filters.normalization.ModuleNormalizer;
import transformation.context.line_filters.normalization.Normalizer;

import static org.junit.Assert.*;

/**
 * Created by moles on 21.09.2016.
 * @author moles
 */
public class ModuleNormalizerTest {
    @Test
    public void normalizing_NotMustNormalization_InputDataSameOutputData() throws Exception {
        Normalizer normalizer=new ModuleNormalizer();
        assertEquals(new RGB(127,14,200),new RGB(normalizer.normalizing(127,14,200)));
    }
    @Test
    public void normalizing_PartInNotScale_Normalize() throws Exception {
        Normalizer normalizer=new ModuleNormalizer();
        assertEquals(new RGB(255,14,200),new RGB(normalizer.normalizing(2560,14,200)));
    }
    @Test
    public void normalizing_NegativeValue_Normalize() throws Exception {
        Normalizer normalizer=new ModuleNormalizer();
        assertEquals(new RGB(127,14,200),new RGB(normalizer.normalizing(127,-14,200)));
    }

}