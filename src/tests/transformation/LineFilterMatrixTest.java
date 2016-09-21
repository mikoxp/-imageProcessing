package tests.transformation;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import transformation.context.line_filters.Mask;
import transformation.context.line_filters.LineFilterMatrix;
import transformation.context.line_filters.normalization.Normalizer;

import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

/**
 * Created by moles on 19.09.2016.
 * @author moles
 */
public class LineFilterMatrixTest {
    private ImageToTest imageToTest=new ImageToTest();
    @Mock
    private Mask mask;
    @Mock
    private BufferedImage image;
    @Mock
    private Normalizer normalizer;
    @Test(expected = NullPointerException.class)
    public void constructor_NormalizerIsNull_NullPointerException(){
        Mockito.when(mask.getSize()).thenReturn(3);
       new LineFilterMatrix(0,0,image,mask,null);
    }
    @Test(expected = NullPointerException.class)
    public void constructor_MaskIsNull_NullPointerException(){
        Mockito.when(mask.getSize()).thenReturn(3);
        new LineFilterMatrix(0,0,image,null,normalizer);
    }

}