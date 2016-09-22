package transformation.point;

import image_data.ImageContainer;
import image_data.ImageCreator;

import java.awt.image.BufferedImage;

/**
 * @author moles
 */
public class PointTransformationManager {
    private ImageCreator imageCreator;
    private int i;
    private int j;
    private RGBPoint rgbPoint;

    public PointTransformationManager() {
        imageCreator = new ImageCreator();
    }

    /**
     *
     * @param container image container
     * @return negative iamge
     */
    public ImageContainer negative(ImageContainer container){
        ImageContainer image = imageCreator
                .createEmpty(container.getFilePath() + "_negative", container.getImageFormat(), container.getNumberOfColumn(), container.getNumberOfLine());
        BufferedImage result = image.getBufferedImage();
        BufferedImage mark = container.getBufferedImage();
        for(i=0; i<container.getNumberOfColumn(); i++){
            for(j=0; j<container.getNumberOfLine(); j++){
                rgbPoint = new RGBPoint(mark.getRGB(i, j));
                rgbPoint.negative();
                result.setRGB(i, j, rgbPoint.getColor().getRGB());
            }
        }
        return image;
    }

    /**
     *
     * @param container image container
     * @return grey scale image
     */
    public ImageContainer greyScale(ImageContainer container){
        ImageContainer image = imageCreator
                .createEmpty(container.getFilePath() + "_greyScale", container.getImageFormat(), container.getNumberOfColumn(), container.getNumberOfLine());
        BufferedImage result = image.getBufferedImage();
        BufferedImage mark = container.getBufferedImage();
        for(i=0; i<container.getNumberOfColumn(); i++){
            for(j=0; j<container.getNumberOfLine(); j++){
                rgbPoint = new RGBPoint(mark.getRGB(i, j));
                rgbPoint.greyScale();
                result.setRGB(i, j, rgbPoint.getColor().getRGB());
            }
        }
        return image;
    }

    /**
     *
     * @param container image container
     * @param factor value between 20 and 40
     * @return sepia image
     */
    public ImageContainer sepia(ImageContainer container, int factor){
        ImageContainer image = imageCreator
                .createEmpty(container.getFilePath() + "_sepia" + factor, container.getImageFormat(), container.getNumberOfColumn(), container.getNumberOfLine());
        BufferedImage result = image.getBufferedImage();
        BufferedImage mark = container.getBufferedImage();
        for(i=0; i<container.getNumberOfColumn(); i++){
            for(j=0; j<container.getNumberOfLine(); j++){
                rgbPoint = new RGBPoint(mark.getRGB(i, j));
                rgbPoint.sepia(factor);
                result.setRGB(i, j, rgbPoint.getColor().getRGB());
            }
        }
        return image;
    }

    /**
     *
     * @param container image container
     * @param fade fade container
     * @return faded color image
     */
    public ImageContainer fadeColor(ImageContainer container,Fade fade){
        ImageContainer image = imageCreator
                .createEmpty(container.getFilePath() + "_fade " + "R " + fade.isRed() + "G " + fade.isGreen() + " B " + fade.isBlue()
                        , container.getImageFormat(), container.getNumberOfColumn(), container.getNumberOfLine());
        BufferedImage result = image.getBufferedImage();
        BufferedImage mark = container.getBufferedImage();
        for(i=0; i<container.getNumberOfColumn(); i++){
            for(j=0; j<container.getNumberOfLine(); j++){
                rgbPoint = new RGBPoint(mark.getRGB(i, j));
                rgbPoint.fadeColor(fade);
                result.setRGB(i, j, rgbPoint.getColor().getRGB());
            }
        }
        return image;
    }
}
