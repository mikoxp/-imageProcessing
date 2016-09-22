package tests.transformation;

import image_data.ImageContainer;
import image_data.ImageCreator;
import image_data.RGB;
import org.junit.Test;
import transformation.context.line_filters.Mask;
import transformation.context.line_filters.normalization.NormalizerRange;
import transformation.context.line_filters.normalization.ScalingNormalizer;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.Assert.assertEquals;

/**
 * Created by moles on 20.09.2016.
 * @author moles
 */
public class ScalingNormalizerTest {
    private ImageCreator imageCreator=new ImageCreator();

    @Test
    public void constructor_calcRange(){
        ImageContainer imageContainer = imageCreator.createEmptyBMP("", 4, 3);
        BufferedImage bufferedImage=imageContainer.getBufferedImage();
        bufferedImage.setRGB(0,0,new RGB(255,255,255).getColor().getRGB());
        bufferedImage.setRGB(3, 0, new RGB(255, 255, 255).getColor().getRGB());

        int [][] value =new int[3][3];
        value[0][0]=2;
        value[2][0] = -2;
        Mask mask=new Mask(value);
        ScalingNormalizer normalizer=new ScalingNormalizer(bufferedImage,mask);
        NormalizerRange range=new NormalizerRange(-510,510);
        assertEquals(range,normalizer.getRedRange());
    }
    @Test
    public void normalizing_Value(){
        NormalizerRange range=new NormalizerRange(-510,510);
        ScalingNormalizer normalizer=new ScalingNormalizer(range,range,range);
        Color color=normalizer.normalizing(0,0,0);
        assertEquals(new RGB(127,127,127),new RGB(color));
    }
}