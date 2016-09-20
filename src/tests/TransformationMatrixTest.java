package tests;

import image_data.RGB;
import org.junit.Test;
import transformation.context.TransformationMatrix;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by moles on 2016-09-18.
 * @author moles
 */
public class TransformationMatrixTest {
    private final int smallSize=3;
    private final int bigSize=5;
   private ImageToTest imageToTest=new ImageToTest();
    @Test(expected = IllegalArgumentException.class)
    public void constructor_sizeIsEven_IllegalArgumentException(){
        new TransformationMatrix(15,15,2,new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB));
    }
    @Test(expected = IllegalArgumentException.class)
    public void constructor_xIsNotInImage_IllegalArgumentException(){
        new TransformationMatrix(150,15,3,new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB));
    }
    @Test(expected = IllegalArgumentException.class)
    public void constructor_yIsNotInImage_IllegalArgumentException(){
        new TransformationMatrix(15,150,3,new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB));
    }
    @Test(expected = IllegalArgumentException.class)
    public void constructor_xIsNegative_IllegalArgumentException(){
        new TransformationMatrix(-15,15,3,new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB));
    }
    @Test(expected = IllegalArgumentException.class)
    public void constructor_yIsNegative_IllegalArgumentException(){
        new TransformationMatrix(15,-150,3,new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB));
    }
    @Test
    public void constructor_AllValue_corectValue(){
        BufferedImage bufferedImage=imageToTest.getBlackImageToTest();
        TransformationMatrix matrix=new TransformationMatrix(5,5,smallSize,bufferedImage);
        RGB[] c1=new RGB[smallSize];
        RGB[] c2=new RGB[smallSize];
        RGB[] c3=new RGB[smallSize];
        for(int i=0;i<smallSize;i++){
            c1[i]=new RGB(0,0,0);
            c2[i]=new RGB(0,0,0);
            c3[i]=new RGB(0,0,0);
        }
        List<RGB[]> rgbs=new ArrayList<RGB[]>();
        rgbs.add(c1);
        rgbs.add(c2);
        rgbs.add(c3);
        for(int i=0;i<rgbs.size();i++){
            assertArrayEquals(rgbs.get(i),matrix.getColumns().get(i));
        }
    }
    @Test
    public void constructor_NotAllValue_corectValue(){
        BufferedImage bufferedImage=imageToTest.getBlackImageToTest();
        TransformationMatrix matrix=new TransformationMatrix(1,0,smallSize,bufferedImage);
        RGB[] c1=new RGB[smallSize];
        RGB[] c2=new RGB[smallSize];
        RGB[] c3=new RGB[smallSize];
        for(int i=0;i<smallSize;i++){
            c1[i]=null;
            c2[i]=new RGB(0,0,0);
            c3[i]=new RGB(0,0,0);
        }
        List<RGB[]> rgbs=new ArrayList<RGB[]>();
        rgbs.add(c1);
        rgbs.add(c2);
        rgbs.add(c3);
        for(int i=0;i<rgbs.size();i++){
            assertArrayEquals(rgbs.get(i),matrix.getColumns().get(i));
        }
    }
    @Test
    public void nextMatrix_CorectValue_corectValue(){
        BufferedImage bufferedImage=imageToTest.getValueImageToTest();
        TransformationMatrix matrix=new TransformationMatrix(1,1,smallSize,bufferedImage);
        matrix.nextMatrix();
        RGB[] c1=new RGB[smallSize];
        RGB[] c2=new RGB[smallSize];
        RGB[] c3=new RGB[smallSize];
        for(int i=0;i<smallSize;i++){
            c1[i]=new RGB(5,5,5);
            c2[i]=new RGB(10,10,9);
            c3[i]=new RGB(15,15,15);
        }
        List<RGB[]> rgbs=new ArrayList<RGB[]>();
        rgbs.add(c1);
        rgbs.add(c2);
        rgbs.add(c3);
        for(int i=0;i<rgbs.size();i++){
            assertArrayEquals(rgbs.get(i),matrix.getColumns().get(i));
        }
    }
    @Test
    public void getColumns_AllfillFileds_numberOfFiled(){
        BufferedImage bufferedImage=imageToTest.getBlackImageToTest();
        TransformationMatrix matrix=new TransformationMatrix(1,1,smallSize,bufferedImage);
        List<RGB[]> columns=matrix.getColumns();
        int i=0;
        for(RGB[] c:columns){
            for(RGB r:c){
                if(r!=null){
                    i++;
                }
            }
        }
       assertEquals(9,i);
    }
    @Test
    public void getColumns_AllfillFiledsBiggest_numberOfFiled(){
        BufferedImage bufferedImage=imageToTest.getBlackImageToTest();
        TransformationMatrix matrix=new TransformationMatrix(2,2,bigSize,bufferedImage);
        List<RGB[]> columns=matrix.getColumns();
        int i=0;
        for(RGB[] c:columns){
            for(RGB r:c){
                if(r!=null){
                    i++;
                }
            }
        }
        assertEquals(25,i);
    }
    @Test
    public void getColumns_incompletefillFileds_numberOfFiled(){
        BufferedImage bufferedImage=imageToTest.getBlackImageToTest();
        TransformationMatrix matrix=new TransformationMatrix(0,0,smallSize,bufferedImage);
        List<RGB[]> columns=matrix.getColumns();
        int i=0;
        for(RGB[] c:columns){
            for(RGB r:c){
                if(r!=null){
                    i++;
                }
            }
        }
        assertEquals(4,i);
    }
    @Test
    public void getColumns_incompletefillFiledsBiggest_numberOfFiled(){
        BufferedImage bufferedImage=imageToTest.getBlackImageToTest();
        TransformationMatrix matrix=new TransformationMatrix(0,0,bigSize,bufferedImage);
        List<RGB[]> columns=matrix.getColumns();
        int i=0;
        for(RGB[] c:columns){
            for(RGB r:c){
                if(r!=null){
                    i++;
                }
            }
        }
        assertEquals(9,i);
    }
    @Test
    public void getElement_chooseElement_ElementRGB(){
        BufferedImage bufferedImage=imageToTest.getValueImageToTest();
        TransformationMatrix matrix=new TransformationMatrix(1,1,smallSize,bufferedImage);
        assertEquals(new RGB(5,5,5),matrix.getElement(0,1));
    }
    @Test(expected = IllegalArgumentException.class)
    public void getElement_incorectCoordinate_IllegalArgumentException(){
        BufferedImage bufferedImage=imageToTest.getValueImageToTest();
        TransformationMatrix matrix=new TransformationMatrix(1,1,smallSize,bufferedImage);
        matrix.getElement(0,5);
    }
    @Test(expected = IllegalArgumentException.class)
    public void getElement_negativeCoordinate_IllegalArgumentException(){
        BufferedImage bufferedImage=imageToTest.getValueImageToTest();
        TransformationMatrix matrix=new TransformationMatrix(1,1,smallSize,bufferedImage);
        matrix.getElement(0,-5);
    }

}