package transformation.binarization;

import image_data.ImageContainer;
import image_data.ImageCreator;
import image_data.RGB;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by moles on 26.09.2016.
 * @author moles
 */
public class Binarization {

    private ImageCreator imageCreator;

    public Binarization() {
        this.imageCreator = new ImageCreator();
    }

    /**
     *
     * @param imageContainer image
     * @return binarizated image
     */
    public ImageContainer lowerThreshold(ImageContainer imageContainer, RGB threshold){
        int color;
        RGB rgb;
        String path=imageContainer.getFilePath()+"_binarization_lower"+threshold;
        ImageContainer image=imageCreator.createEmpty(path,imageContainer.getImageFormat(),imageContainer.getNumberOfColumn(),imageContainer.getNumberOfLine());
        BufferedImage mark=imageContainer.getBufferedImage();
        BufferedImage result=image.getBufferedImage();
        for(int i=0;i<image.getNumberOfColumn();i++){
            for(int j=0;j<image.getNumberOfLine();j++){
                color=mark.getRGB(i,j);
                result.setRGB(i,j,lowerThreshold_Changer(color,threshold));
            }
        }
        return image;
    }

    /**
     *
     * @param color color
     * @param threshold threshold
     * @return color [int]
     */
    private int lowerThreshold_Changer(int color, RGB threshold){
        RGB rgb=new RGB(color);
        if(rgb.getRed()>threshold.getRed()){
            rgb.setRed(255);
        }
        else {
            rgb.setRed(0);
        }
        if(rgb.getGreen()>threshold.getGreen()){
            rgb.setGreen(255);
        }else{
            rgb.setGreen(0);
        }
        if(rgb.getBlue()>threshold.getBlue()){
            rgb.setBlue(255);
        }else {
            rgb.setBlue(0);
        }
        return rgb.getColor().getRGB();
    }
    /**
     *
     * @param imageContainer image
     * @return binarizated image
     */
    public ImageContainer upperThreshold(ImageContainer imageContainer, RGB threshold){
        int color;
        RGB rgb;
        String path=imageContainer.getFilePath()+"_binarization_upper"+threshold;
        ImageContainer image=imageCreator.createEmpty(path,imageContainer.getImageFormat(),imageContainer.getNumberOfColumn(),imageContainer.getNumberOfLine());
        BufferedImage mark=imageContainer.getBufferedImage();
        BufferedImage result=image.getBufferedImage();
        for(int i=0;i<image.getNumberOfColumn();i++){
            for(int j=0;j<image.getNumberOfLine();j++){
                color=mark.getRGB(i,j);
                result.setRGB(i,j,upperThreshold_Changer(color,threshold));
            }
        }
        return image;
    }

    /**
     *
     * @param color color
     * @param threshold threshold
     * @return color [int]
     */
    private int upperThreshold_Changer(int color, RGB threshold){
        RGB rgb=new RGB(color);
        if(rgb.getRed()<threshold.getRed()){
            rgb.setRed(255);
        }
        else {
            rgb.setRed(0);
        }
        if(rgb.getGreen()<threshold.getGreen()){
            rgb.setGreen(255);
        }else{
            rgb.setGreen(0);
        }
        if(rgb.getBlue()<threshold.getBlue()){
            rgb.setBlue(255);
        }else {
            rgb.setBlue(0);
        }
        return rgb.getColor().getRGB();
    }
    /**
     *
     * @param imageContainer image
     * @return binarizated image
     */
    public ImageContainer doubleThreshold(ImageContainer imageContainer, RGB lower,RGB upper){
        int color;
        RGB rgb;
        String path=imageContainer.getFilePath()+"_binarization_double"+lower+"_"+upper;
        ImageContainer image=imageCreator.createEmpty(path,imageContainer.getImageFormat(),imageContainer.getNumberOfColumn(),imageContainer.getNumberOfLine());
        BufferedImage mark=imageContainer.getBufferedImage();
        BufferedImage result=image.getBufferedImage();
        for(int i=0;i<image.getNumberOfColumn();i++){
            for(int j=0;j<image.getNumberOfLine();j++){
                color=mark.getRGB(i,j);
                result.setRGB(i,j,doubleThreshold_Changer(color,lower,upper));
            }
        }
        return image;
    }

    /**
     *
     * @param color color
     * @param lower lower
     * @param upper upper
     * @return color [int]
     */
    private int doubleThreshold_Changer(int color, RGB lower,RGB upper){
        RGB rgb=new RGB(color);
        if(rgb.getRed()>lower.getRed()&&rgb.getRed()<upper.getRed()){
            rgb.setRed(255);
        }
        else {
            rgb.setRed(0);
        }
        if(rgb.getGreen()>lower.getGreen()&&rgb.getGreen()<upper.getGreen()){
            rgb.setGreen(255);
        }else{
            rgb.setGreen(0);
        }
        if(rgb.getBlue()>lower.getBlue()&&rgb.getBlue()<upper.getBlue()){
            rgb.setBlue(255);
        }else {
            rgb.setBlue(0);
        }
        return rgb.getColor().getRGB();
    }
}
