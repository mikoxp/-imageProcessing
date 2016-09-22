package tests.transformation;

import image_data.ImageContainer;
import image_data.ImageCreator;
import image_data.RGB;
import org.junit.Test;
import transformation.context.nonlinear_filters.NonLinearFilterMatrix;

import java.awt.image.BufferedImage;

import static org.junit.Assert.assertEquals;

/**
 * Created by moles on 19.09.2016.
 * @author moles
 */
public class NonLinearFilterMatrixTest {
    private ImageCreator imageCreator = new ImageCreator();

    @Test
    public void maximalValue_compliteMatrix_Value() {
        ImageContainer imageContainer = imageCreator.createEmptyBMP("", 100, 100);
        BufferedImage bufferedImage = imageContainer.getBufferedImage();
        RGB rgb = new RGB(15, 15, 15);
        int color = rgb.getColor().getRGB();
        for (int i = 0; i < 10; i++) {
            bufferedImage.setRGB(0, i, color);
            bufferedImage.setRGB(3, i, color);
        }
        rgb = new RGB(5, 5, 5);
        color = rgb.getColor().getRGB();
        for (int i = 0; i < 10; i++) {
            bufferedImage.setRGB(1, i, color);
            bufferedImage.setRGB(4, i, color);
        }
        rgb = new RGB(10, 10, 9);
        color = rgb.getColor().getRGB();
        for (int i = 0; i < 10; i++) {
            bufferedImage.setRGB(2, i, color);
            bufferedImage.setRGB(5, i, color);
        }
        NonLinearFilterMatrix nonLinearFilterMatrix = new NonLinearFilterMatrix(1, 1, 3, bufferedImage);
        assertEquals(new RGB(15, 15, 15).getColor(), nonLinearFilterMatrix.maximalValue());
    }

    @Test
    public void maximalValue_incopliteMatrix_Value() {
        ImageContainer imageContainer = imageCreator.createEmptyBMP("", 100, 100);
        BufferedImage bufferedImage = imageContainer.getBufferedImage();
        RGB rgb = new RGB(15, 15, 15);
        int color = rgb.getColor().getRGB();
        for (int i = 0; i < 10; i++) {
            bufferedImage.setRGB(0, i, color);
            bufferedImage.setRGB(3, i, color);
        }
        rgb = new RGB(5, 5, 5);
        color = rgb.getColor().getRGB();
        for (int i = 0; i < 10; i++) {
            bufferedImage.setRGB(1, i, color);
            bufferedImage.setRGB(4, i, color);
        }
        rgb = new RGB(10, 10, 9);
        color = rgb.getColor().getRGB();
        for (int i = 0; i < 10; i++) {
            bufferedImage.setRGB(2, i, color);
            bufferedImage.setRGB(5, i, color);
        }
        NonLinearFilterMatrix nonLinearFilterMatrix = new NonLinearFilterMatrix(0, 0, 3, bufferedImage);
        assertEquals(new RGB(15, 15, 15).getColor(), nonLinearFilterMatrix.maximalValue());
    }

    @Test
    public void minimalValue_compliteMatrix_Value() {
        ImageContainer imageContainer = imageCreator.createEmptyBMP("", 100, 100);
        BufferedImage bufferedImage = imageContainer.getBufferedImage();
        RGB rgb = new RGB(15, 15, 15);
        int color = rgb.getColor().getRGB();
        for (int i = 0; i < 10; i++) {
            bufferedImage.setRGB(0, i, color);
            bufferedImage.setRGB(3, i, color);
        }
        rgb = new RGB(5, 5, 5);
        color = rgb.getColor().getRGB();
        for (int i = 0; i < 10; i++) {
            bufferedImage.setRGB(1, i, color);
            bufferedImage.setRGB(4, i, color);
        }
        rgb = new RGB(10, 10, 9);
        color = rgb.getColor().getRGB();
        for (int i = 0; i < 10; i++) {
            bufferedImage.setRGB(2, i, color);
            bufferedImage.setRGB(5, i, color);
        }
        NonLinearFilterMatrix nonLinearFilterMatrix = new NonLinearFilterMatrix(1, 1, 3, bufferedImage);
        assertEquals(new RGB(5, 5, 5).getColor(), nonLinearFilterMatrix.minimalValue());
    }
    @Test
    public void minimalValue_incopliteMatrix_Value(){
        ImageContainer imageContainer = imageCreator.createEmptyBMP("", 100, 100);
        BufferedImage bufferedImage = imageContainer.getBufferedImage();
        RGB rgb = new RGB(15, 15, 15);
        int color = rgb.getColor().getRGB();
        for (int i = 0; i < 10; i++) {
            bufferedImage.setRGB(0, i, color);
            bufferedImage.setRGB(3, i, color);
        }
        rgb = new RGB(5, 5, 5);
        color = rgb.getColor().getRGB();
        for (int i = 0; i < 10; i++) {
            bufferedImage.setRGB(1, i, color);
            bufferedImage.setRGB(4, i, color);
        }
        rgb = new RGB(10, 10, 9);
        color = rgb.getColor().getRGB();
        for (int i = 0; i < 10; i++) {
            bufferedImage.setRGB(2, i, color);
            bufferedImage.setRGB(5, i, color);
        }
        NonLinearFilterMatrix nonLinearFilterMatrix = new NonLinearFilterMatrix(0, 0, 3, bufferedImage);
        assertEquals(new RGB(5, 5, 5).getColor(), nonLinearFilterMatrix.minimalValue());
    }
    @Test
    public void medianValue_compliteMatrix_Value(){
        ImageContainer imageContainer = imageCreator.createEmptyBMP("", 100, 100);
        BufferedImage bufferedImage = imageContainer.getBufferedImage();
        RGB rgb = new RGB(15, 15, 15);
        int color = rgb.getColor().getRGB();
        for (int i = 0; i < 10; i++) {
            bufferedImage.setRGB(0, i, color);
            bufferedImage.setRGB(3, i, color);
        }
        rgb = new RGB(5, 5, 5);
        color = rgb.getColor().getRGB();
        for (int i = 0; i < 10; i++) {
            bufferedImage.setRGB(1, i, color);
            bufferedImage.setRGB(4, i, color);
        }
        rgb = new RGB(10, 10, 9);
        color = rgb.getColor().getRGB();
        for (int i = 0; i < 10; i++) {
            bufferedImage.setRGB(2, i, color);
            bufferedImage.setRGB(5, i, color);
        }
        NonLinearFilterMatrix nonLinearFilterMatrix=new NonLinearFilterMatrix(1,1,3,bufferedImage);
        assertEquals(new RGB(10,10,9).getColor(),nonLinearFilterMatrix.medianValue());
    }
    @Test
    public void medianValue_incopliteMatrix_Value(){
        ImageContainer imageContainer = imageCreator.createEmptyBMP("", 100, 100);
        BufferedImage bufferedImage = imageContainer.getBufferedImage();
        RGB rgb = new RGB(15, 15, 15);
        int color = rgb.getColor().getRGB();
        for (int i = 0; i < 10; i++) {
            bufferedImage.setRGB(0, i, color);
            bufferedImage.setRGB(3, i, color);
        }
        rgb = new RGB(5, 5, 5);
        color = rgb.getColor().getRGB();
        for (int i = 0; i < 10; i++) {
            bufferedImage.setRGB(1, i, color);
            bufferedImage.setRGB(4, i, color);
        }
        rgb = new RGB(10, 10, 9);
        color = rgb.getColor().getRGB();
        for (int i = 0; i < 10; i++) {
            bufferedImage.setRGB(2, i, color);
            bufferedImage.setRGB(5, i, color);
        }
        NonLinearFilterMatrix nonLinearFilterMatrix=new NonLinearFilterMatrix(0,0,3,bufferedImage);
        assertEquals(new RGB(10,10,10).getColor(),nonLinearFilterMatrix.medianValue());
    }
    @Test
    public void medianValue_incopliteMatrixBiggestSize_Value(){
        ImageContainer imageContainer = imageCreator.createEmptyBMP("", 100, 100);
        BufferedImage bufferedImage = imageContainer.getBufferedImage();
        RGB rgb = new RGB(15, 15, 15);
        int color = rgb.getColor().getRGB();
        for (int i = 0; i < 10; i++) {
            bufferedImage.setRGB(0, i, color);
            bufferedImage.setRGB(3, i, color);
        }
        rgb = new RGB(5, 5, 5);
        color = rgb.getColor().getRGB();
        for (int i = 0; i < 10; i++) {
            bufferedImage.setRGB(1, i, color);
            bufferedImage.setRGB(4, i, color);
        }
        rgb = new RGB(10, 10, 9);
        color = rgb.getColor().getRGB();
        for (int i = 0; i < 10; i++) {
            bufferedImage.setRGB(2, i, color);
            bufferedImage.setRGB(5, i, color);
        }
        NonLinearFilterMatrix nonLinearFilterMatrix=new NonLinearFilterMatrix(1,1,5,bufferedImage);
        assertEquals(new RGB(12,12,12).getColor(),nonLinearFilterMatrix.medianValue());
    }
}