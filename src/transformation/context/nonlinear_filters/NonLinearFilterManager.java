package transformation.context.nonlinear_filters;

import image_data.ImageContainer;
import image_data.ImageCreator;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by moles on 22.09.2016.
 * @author moles
 */
public class NonLinearFilterManager {
    private ImageCreator imageCreator;
    private NonLinearFilterMatrix nonLinearFilterMatrix;
    private Color color;

    public NonLinearFilterManager() {
        imageCreator=new ImageCreator();
    }
    public ImageContainer maximalValue(ImageContainer imageContainer,int contextSize){
        if(contextSize%2==0){
            throw new IllegalArgumentException("contextSize must be odd");
        }
        ImageContainer image = imageCreator
                .createEmpty(imageContainer.getFilePath() + "_nonLinearFilter_maximalValue "+contextSize
                        , imageContainer.getImageFormat(), imageContainer.getNumberOfColumn(), imageContainer.getNumberOfLine());
        BufferedImage result = image.getBufferedImage();
        BufferedImage mark = imageContainer.getBufferedImage();
        for (int i = 0; i < imageContainer.getNumberOfLine(); i++) {
            nonLinearFilterMatrix=new NonLinearFilterMatrix(0,i,contextSize,mark);
            for (int j = 0; j < imageContainer.getNumberOfColumn(); j++) {
                color = nonLinearFilterMatrix.maximalValue();
                result.setRGB(j, i, color.getRGB());
                nonLinearFilterMatrix.moveOnColumn();
            }
        }
        return image;
    }
    public ImageContainer minimalValue(ImageContainer imageContainer,int contextSize){
        if(contextSize%2==0){
            throw new IllegalArgumentException("contextSize must be odd");
        }
        ImageContainer image = imageCreator
                .createEmpty(imageContainer.getFilePath() + "_nonLinearFilter_minimalValue "+contextSize
                        , imageContainer.getImageFormat(), imageContainer.getNumberOfColumn(), imageContainer.getNumberOfLine());
        BufferedImage result = image.getBufferedImage();
        BufferedImage mark = imageContainer.getBufferedImage();
        for (int i = 0; i < imageContainer.getNumberOfLine(); i++) {
            nonLinearFilterMatrix=new NonLinearFilterMatrix(0,i,contextSize,mark);
            for (int j = 0; j < imageContainer.getNumberOfColumn(); j++) {
                color = nonLinearFilterMatrix.minimalValue();
                result.setRGB(j, i, color.getRGB());
                nonLinearFilterMatrix.moveOnColumn();
            }
        }
        return image;
    }
    public ImageContainer medianValue(ImageContainer imageContainer,int contextSize){
        if(contextSize%2==0){
            throw new IllegalArgumentException("contextSize must be odd");
        }
        ImageContainer image = imageCreator
                .createEmpty(imageContainer.getFilePath() + "_nonLinearFilter_medianValue "+contextSize
                        , imageContainer.getImageFormat(), imageContainer.getNumberOfColumn(), imageContainer.getNumberOfLine());
        BufferedImage result = image.getBufferedImage();
        BufferedImage mark = imageContainer.getBufferedImage();
        for (int i = 0; i < imageContainer.getNumberOfLine(); i++) {
            nonLinearFilterMatrix=new NonLinearFilterMatrix(0,i,contextSize,mark);
            for (int j = 0; j < imageContainer.getNumberOfColumn(); j++) {
                color = nonLinearFilterMatrix.medianValue();
                result.setRGB(j, i, color.getRGB());
                nonLinearFilterMatrix.moveOnColumn();
            }
        }
        return image;
    }


}
