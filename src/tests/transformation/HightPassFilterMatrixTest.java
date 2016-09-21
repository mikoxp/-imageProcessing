package tests.transformation;

import image_data.ImageContainer;
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
        ImageContainer imageContainer = imageCreator.createEmptyBMP("", 3, 3);
        BufferedImage bufferedImage = imageContainer.getBufferedImage();
        bufferedImage.setRGB(0, 0, new RGB(255, 255, 255).getColor().getRGB());
        bufferedImage.setRGB(0, 2, new RGB(255, 255, 255).getColor().getRGB());
        bufferedImage.setRGB(1, 0, new RGB(125, 125, 125).getColor().getRGB());
        bufferedImage.setRGB(1, 1, new RGB(200, 200, 200).getColor().getRGB());

        int[][] value = new int[3][3];
        value[0][0] = 2;
        value[0][2] = -2;
        value[1][0] = 2;
        value[1][1] = -1;
        value[1][2] = -2;
        value[2][1] = 2;
        Mask mask = new Mask(value);
        Normalizer normalizer = new ModuleNormalizer();
        hightPassFilterMatrix = new HightPassFilterMatrix(1, 1, bufferedImage, mask, normalizer);
        Color color = hightPassFilterMatrix.getFiltredValue();
        Assert.assertEquals(new RGB(50, 50, 50), new RGB(color));
    }

    @Test
    public void getFiltredValue_MarginPoint() throws Exception {
        ImageContainer imageContainer = imageCreator.createEmptyBMP("", 3, 3);
        BufferedImage bufferedImage = imageContainer.getBufferedImage();
        bufferedImage.setRGB(0, 0, new RGB(255, 255, 255).getColor().getRGB());
        bufferedImage.setRGB(0, 2, new RGB(255, 255, 255).getColor().getRGB());
        bufferedImage.setRGB(1, 0, new RGB(125, 125, 125).getColor().getRGB());
        bufferedImage.setRGB(1, 1, new RGB(200, 200, 200).getColor().getRGB());

        int[][] value = new int[3][3];
        value[0][0] = 2;
        value[0][2] = -2;
        value[1][0] = 2;
        value[1][1] = -1;
        value[1][2] = -2;
        value[2][1] = 2;
        Mask mask = new Mask(value);
        Normalizer normalizer = new ModuleNormalizer();
        hightPassFilterMatrix = new HightPassFilterMatrix(0, 0, bufferedImage, mask, normalizer);
        Color color = hightPassFilterMatrix.getFiltredValue();
        Assert.assertEquals(new RGB(5, 5, 5), new RGB(color));
    }


}