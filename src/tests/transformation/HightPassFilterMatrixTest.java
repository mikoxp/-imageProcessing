package tests.transformation;

import image_data.ImageCreator;
import image_data.RGB;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import transformation.context.line_filters.HightPassFilterMatrix;
import transformation.context.line_filters.Mask;
import transformation.context.line_filters.normalization.ModuleNormalizer;
import transformation.context.line_filters.normalization.Normalizer;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by moles on 19.09.2016.
 * @author moles
 */
public class HightPassFilterMatrixTest {

    private HightPassFilterMatrix hightPassFilterMatrix;
    private ImageCreator imageCreator = new ImageCreator();
    @Mock
    private Mask mask;
    @Mock
    private BufferedImage image;
    @Mock
    private Normalizer normalizer;

    @Test(expected = NullPointerException.class)
    public void constructor_NormalizerIsNull_NullPointerException(){
        Mockito.when(mask.getSize()).thenReturn(3);
        new HightPassFilterMatrix(0, 0, image, mask, null);
    }

    @Test(expected = NullPointerException.class)
    public void constructor_MaskIsNull_NullPointerException(){
        Mockito.when(mask.getSize()).thenReturn(3);
        new HightPassFilterMatrix(0, 0, image, null, normalizer);
    }

    @Test
    public void getFiltredValue_FullField() throws Exception {
        int[][] value = new int[3][3];
        value[0][0]=-1;
        value[0][1] = -1;
        value[0][2] = -1;
        value[2][0] = 1;
        value[2][1] = 1;
        value[2][2]=1;
        Mask mask = new Mask(value);
        Normalizer normalizer = new ModuleNormalizer();
        BufferedImage mark=imageCreator.createEmptyBMP("",3,3).getBufferedImage();
        RGB rgb;
        int index=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                index++;
                rgb=new RGB(index,index,index);
                mark.setRGB(j,i,rgb.getColor().getRGB());
            }
        }
        hightPassFilterMatrix=new HightPassFilterMatrix(1,1,mark,mask,normalizer);
        Color color=hightPassFilterMatrix.getFiltredValue();
        Assert.assertEquals(new RGB(6,6,6),new RGB(color));
    }

    @Test
    public void getFiltredValue_MarginPoint() throws Exception {
        int[][] value = new int[3][3];
        value[0][0]=-1;
        value[0][1] = -1;
        value[0][2] = -1;
        value[2][0] = 1;
        value[2][1] = 1;
        value[2][2]=1;
        Mask mask = new Mask(value);
        Normalizer normalizer = new ModuleNormalizer();
        BufferedImage mark=imageCreator.createEmptyBMP("",3,3).getBufferedImage();
        RGB rgb;
        int index=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                index++;
                rgb=new RGB(index,index,index);
                mark.setRGB(j,i,rgb.getColor().getRGB());
            }
        }
        hightPassFilterMatrix=new HightPassFilterMatrix(0,0,mark,mask,normalizer);
        Color color=hightPassFilterMatrix.getFiltredValue();
        Assert.assertEquals(new RGB(7,7,7),new RGB(color));
}


}