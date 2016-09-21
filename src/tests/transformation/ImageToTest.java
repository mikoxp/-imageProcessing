package tests.transformation;

import image_data.ImageContainer;
import image_data.ImageCreator;
import image_data.RGB;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by moles on 2016-09-18.
 * @author moles
 */
public class ImageToTest {
    private ImageCreator imageCreator = new ImageCreator();

    /**
     *
     * @return black image to test
     */
    public BufferedImage getBlackImageToTest(){
        ImageContainer imageContainer=imageCreator.createEmptyBMP("",100,100);
        BufferedImage bufferedImage=imageContainer.getBufferedImage();
        return bufferedImage;
    }
    public BufferedImage getValueImageToTest(){
        ImageContainer imageContainer=imageCreator.createEmptyBMP("",100,100);
        BufferedImage bufferedImage=imageContainer.getBufferedImage();
        RGB rgb=new RGB(15,15,15);
        int color=rgb.getColor().getRGB();
        for(int i=0;i<10;i++){
            bufferedImage.setRGB(i,0,color);
            bufferedImage.setRGB(i,3,color);
        }
        rgb=new RGB(5,5,5);
        color=rgb.getColor().getRGB();
        for(int i=0;i<10;i++){
            bufferedImage.setRGB(i,1,color);
            bufferedImage.setRGB(i,4,color);
        }
        rgb=new RGB(10,10,9);
        color=rgb.getColor().getRGB();
        for(int i=0;i<10;i++){
            bufferedImage.setRGB(i,2,color);
            bufferedImage.setRGB(i,5,color);
        }
        return bufferedImage;
    }

}
