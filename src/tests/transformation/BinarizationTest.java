package tests.transformation;

import image_data.ImageContainer;
import image_data.ImageCreator;
import image_data.RGB;
import org.junit.Test;
import transformation.binarization.Binarization;
import static org.junit.Assert.*;

/**
 * Created by moles on 26.09.2016.
 * @author moles
 */
public class BinarizationTest {
    private ImageCreator imageCreator=new ImageCreator();
    private Binarization binarization=new Binarization();

    @Test(expected = IllegalArgumentException.class)
    public void lowerThreshold_argumetsIsNull_IllegalArgumentException(){
        new Binarization().lowerThreshold(null,null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void upperThreshold_argumetsIsNull_IllegalArgumentException(){
        new Binarization().upperThreshold(null,null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void doubleThreshold_argumetsIsNull_IllegalArgumentException(){
        new Binarization().doubleThreshold(null,null,null);
    }
    @Test
    public void lowerThreshold_Value_CorectValue(){
        ImageContainer imageContainer=imageCreator.createEmptyBMP("",1,1);
        imageContainer.getBufferedImage().setRGB(0,0,new RGB(0,105,200).getColor().getRGB());
        ImageContainer image=binarization.lowerThreshold(imageContainer,new RGB(100,100,100));
        assertEquals(new RGB(0,255,255),new RGB(image.getBufferedImage().getRGB(0,0)));
    }
    @Test
    public void upperThreshold_Value_CorectValue(){
        ImageContainer imageContainer=imageCreator.createEmptyBMP("",1,1);
        imageContainer.getBufferedImage().setRGB(0,0,new RGB(0,105,200).getColor().getRGB());
        ImageContainer image=binarization.upperThreshold(imageContainer,new RGB(100,100,100));
        assertEquals(new RGB(255,0,0),new RGB(image.getBufferedImage().getRGB(0,0)));
    }
    @Test
    public void doubleThreshold_Value_CorectValue(){
        ImageContainer imageContainer=imageCreator.createEmptyBMP("",1,1);
        imageContainer.getBufferedImage().setRGB(0,0,new RGB(0,105,200).getColor().getRGB());
        ImageContainer image=binarization.doubleThreshold(imageContainer,new RGB(100,100,100),new RGB(115,115,115));
        assertEquals(new RGB(0,255,0),new RGB(image.getBufferedImage().getRGB(0,0)));
    }
}