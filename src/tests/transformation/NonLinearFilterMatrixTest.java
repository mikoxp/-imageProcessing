package tests.transformation;

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
    private ImageToTest imageToTest=new ImageToTest();

    @Test
    public void maximalValue_compliteMatrix_Value() {
        BufferedImage bufferedImage = imageToTest.getValueImageToTest();
        NonLinearFilterMatrix nonLinearFilterMatrix = new NonLinearFilterMatrix(1, 1, 3, bufferedImage);
        assertEquals(new RGB(15, 15, 15), nonLinearFilterMatrix.maximalValue());
    }

    @Test
    public void maximalValue_incopliteMatrix_Value() {
        BufferedImage bufferedImage = imageToTest.getValueImageToTest();
        NonLinearFilterMatrix nonLinearFilterMatrix = new NonLinearFilterMatrix(0, 0, 3, bufferedImage);
        assertEquals(new RGB(15, 15, 15), nonLinearFilterMatrix.maximalValue());
    }

    @Test
    public void minimalValue_compliteMatrix_Value() {
        BufferedImage bufferedImage = imageToTest.getValueImageToTest();
        NonLinearFilterMatrix nonLinearFilterMatrix = new NonLinearFilterMatrix(1, 1, 3, bufferedImage);
        assertEquals(new RGB(5, 5, 5), nonLinearFilterMatrix.minimalValue());
    }
    @Test
    public void minimalValue_incopliteMatrix_Value(){
        BufferedImage bufferedImage = imageToTest.getValueImageToTest();
        NonLinearFilterMatrix nonLinearFilterMatrix = new NonLinearFilterMatrix(0, 0, 3, bufferedImage);
        assertEquals(new RGB(5, 5, 5), nonLinearFilterMatrix.minimalValue());
    }
    @Test
    public void medianValue_compliteMatrix_Value(){
        BufferedImage bufferedImage=imageToTest.getValueImageToTest();
        NonLinearFilterMatrix nonLinearFilterMatrix=new NonLinearFilterMatrix(1,1,3,bufferedImage);
        assertEquals(new RGB(10,10,9),nonLinearFilterMatrix.medianValue());
    }
    @Test
    public void medianValue_incopliteMatrix_Value(){
        BufferedImage bufferedImage=imageToTest.getValueImageToTest();
        NonLinearFilterMatrix nonLinearFilterMatrix=new NonLinearFilterMatrix(0,0,3,bufferedImage);
        assertEquals(new RGB(10,10,10),nonLinearFilterMatrix.medianValue());
    }
    @Test
    public void medianValue_incopliteMatrixBiggestSize_Value(){
        BufferedImage bufferedImage=imageToTest.getValueImageToTest();
        NonLinearFilterMatrix nonLinearFilterMatrix=new NonLinearFilterMatrix(1,1,5,bufferedImage);
        assertEquals(new RGB(12,12,12),nonLinearFilterMatrix.medianValue());
    }
}