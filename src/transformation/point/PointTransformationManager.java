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
        container.setFilePath(container.getFilePath() + "_negative");
        BufferedImage bufferedImage = container.getBufferedImage();
        for(i=0; i<container.getNumberOfColumn(); i++){
            for(j=0; j<container.getNumberOfLine(); j++){
                rgbPoint=new RGBPoint(bufferedImage.getRGB(i,j));
                rgbPoint.negative();
                bufferedImage.setRGB(i,j,rgbPoint.getColor().getRGB());
            }
        }
        return container;
    }

    /**
     *
     * @param container image container
     * @return grey scale image
     */
    public ImageContainer greyScale(ImageContainer container){
        container.setFilePath(container.getFilePath() + "_greyScale");
        BufferedImage bufferedImage = container.getBufferedImage();
        for(i=0; i<container.getNumberOfColumn(); i++){
            for(j=0; j<container.getNumberOfLine(); j++){
                rgbPoint=new RGBPoint(bufferedImage.getRGB(i,j));
                rgbPoint.greyScale();
                bufferedImage.setRGB(i,j,rgbPoint.getColor().getRGB());
            }
        }
        return container;
    }

    /**
     *
     * @param container image container
     * @param factor value between 20 and 40
     * @return sepia image
     */
    public ImageContainer sepia(ImageContainer container, int factor){
        container.setFilePath(container.getFilePath() + "_sepia" + factor);
        BufferedImage bufferedImage = container.getBufferedImage();
        for(i=0; i<container.getNumberOfColumn(); i++){
            for(j=0; j<container.getNumberOfLine(); j++){
                rgbPoint=new RGBPoint(bufferedImage.getRGB(i,j));
                rgbPoint.sepia(factor);
                bufferedImage.setRGB(i,j,rgbPoint.getColor().getRGB());
            }
        }
        return container;
    }

    /**
     *
     * @param container image container
     * @param fade fade container
     * @return faded color image
     */
    public ImageContainer fadeColor(ImageContainer container,Fade fade){
        container.setFilePath(container.getFilePath() + "_fade" + fade.isRed() + fade.isGreen() + fade.isBlue());
        BufferedImage bufferedImage = container.getBufferedImage();
        for(i=0; i<container.getNumberOfColumn(); i++){
            for(j=0; j<container.getNumberOfLine(); j++){
                rgbPoint=new RGBPoint(bufferedImage.getRGB(i,j));
                rgbPoint.fadeColor(fade);
                bufferedImage.setRGB(i,j,rgbPoint.getColor().getRGB());
            }
        }
        return container;
    }
}
