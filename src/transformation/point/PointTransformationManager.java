package transformation.point;

import image_data.ImageContainer;

import java.awt.image.BufferedImage;

/**
 * @author moles
 */
public class PointTransformationManager {

    private int i;
    private int j;
    private RGBPoint rgbPoint;
    /**
     *
     * @param container image container
     * @return negative iamge
     */
    public ImageContainer negative(ImageContainer container){
        BufferedImage bufferedImage = container.getBufferedImage();
        for(i=0;i<container.getWidth();i++){
            for(j=0;j<container.getHeight();j++){
                rgbPoint=new RGBPoint(bufferedImage.getRGB(i,j));
                rgbPoint.negative();
                bufferedImage.setRGB(i,j,rgbPoint.getColor().getRGB());
            }
        }
        container.setBufferedImage(bufferedImage);
        return container;
    }

    /**
     *
     * @param container image container
     * @return grey scale image
     */
    public ImageContainer greyScale(ImageContainer container){
        BufferedImage bufferedImage = container.getBufferedImage();
        for(i=0;i<container.getWidth();i++){
            for(j=0;j<container.getHeight();j++){

            }
        }
        container.setBufferedImage(bufferedImage);
        return container;
    }

    /**
     *
     * @param container image container
     * @param factor value between 20 and 40
     * @return sepia image
     */
    public ImageContainer sepia(ImageContainer container, int factor){
        BufferedImage bufferedImage = container.getBufferedImage();
        for(i=0;i<container.getWidth();i++){
            for(j=0;j<container.getHeight();j++){

            }
        }
        container.setBufferedImage(bufferedImage);
        return container;
    }

    /**
     *
     * @param container image container
     * @param fade fade container
     * @return faded color image
     */
    public ImageContainer fadeColor(ImageContainer container,Fade fade){
        BufferedImage bufferedImage = container.getBufferedImage();
        for(i=0;i<container.getWidth();i++){
            for(j=0;j<container.getHeight();j++){

            }
        }
        container.setBufferedImage(bufferedImage);
        return container;
    }
}
