package tests.transformation;

import image_data.ImageCreator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import transformation.context.line_filters.LowPassFilterMatrix;
import transformation.context.line_filters.Mask;

import java.awt.image.BufferedImage;

/**
 * Created by moles on 21.09.2016.
 *
 * @author moles
 */
public class LowPassFilterMatrixTest {
    @Mock
    private Mask mask;
    @Mock
    private BufferedImage image;
    private ImageCreator imageCreator=new ImageCreator();

    @Test(expected = NullPointerException.class)
    public void constructor_MaskIsNull_NullPointerException() {
        new LowPassFilterMatrix(0, 0, null, image);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_elementInMaskIsNegative_illegalArgumentException(){
        BufferedImage bufferedImage=imageCreator.createEmptyBMP("",100,1000).getBufferedImage();
        int [][] v=new int[3][3];
        v[0][1]=-1;
        Mask mask=new Mask(v);
        new LowPassFilterMatrix(0,0,mask,bufferedImage);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_sumIsEqueals0_illegalArgumentException(){
        BufferedImage bufferedImage=imageCreator.createEmptyBMP("",100,1000).getBufferedImage();
        int [][] v=new int[3][3];
        Mask mask=new Mask(v);
        new LowPassFilterMatrix(0,0,mask,bufferedImage);
    }

    @Test
    public void getMaskSum_corectValue(){
        BufferedImage bufferedImage=imageCreator.createEmptyBMP("",100,1000).getBufferedImage();
        int [][] v=new int[3][3];
        v[0][0]=1;
        v[1][1]=3;
        Mask mask=new Mask(v);
        LowPassFilterMatrix lowPassFilterMatrix=new LowPassFilterMatrix(0,0,mask,bufferedImage);
        Assert.assertEquals(4,lowPassFilterMatrix.getMaskSum());
    }

}