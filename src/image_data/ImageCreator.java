package image_data;

import java.awt.image.BufferedImage;

/**
 * Created by moles on 2016-09-09.
 * @author moles
 */
public class ImageCreator {
    /**
     * image is transparent
     * @param path path
     * @param width width
     * @param height height
     * @return create iamge
     */
    public ImageContainer createEmptyPNG(String path,int width,int height){
        BufferedImage empty = new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB);
        ImageContainer imageContainer=new ImageContainer(empty,path,ImageFormat.PNG);
        return imageContainer;
    }
    /**
     * image is not transparent
     * @param path path
     * @param width width
     * @param height height
     * @return create iamge
     */
    public ImageContainer createEmptyBMP(String path,int width,int height){
        BufferedImage empty = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
        ImageContainer imageContainer=new ImageContainer(empty,path,ImageFormat.JPG);
        imageContainer.setImageFormat(ImageFormat.BMP);
        return imageContainer;
    }
}
