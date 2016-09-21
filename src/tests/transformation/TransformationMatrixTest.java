package tests.transformation;

import image_data.ImageCreator;
import image_data.RGB;
import org.junit.Test;
import transformation.context.TransformationMatrix;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by moles on 2016-09-18.
 * @author moles
 */
public class TransformationMatrixTest {
    private final int smallSize=3;
    private final int bigSize=5;
   private ImageToTest imageToTest=new ImageToTest();
    private ImageCreator imageCreator=new ImageCreator();
    @Test(expected = NullPointerException.class)
    public void constructor_BufforedImageIsNull_NullPointerException(){
        new TransformationMatrix(0,0,3,null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void constructor_sizeIsEven_IllegalArgumentException(){
        new TransformationMatrix(15,15,2,new BufferedImage(200,100,BufferedImage.TYPE_INT_RGB));
    }
    @Test(expected = IllegalArgumentException.class)
    public void constructor_columnIsNotInImage_IllegalArgumentException(){
        new TransformationMatrix(250,15,3,new BufferedImage(200,100,BufferedImage.TYPE_INT_RGB));
    }
    @Test(expected = IllegalArgumentException.class)
    public void constructor_LineIsNotInImage_IllegalArgumentException(){
        new TransformationMatrix(15,250,3,new BufferedImage(100,200,BufferedImage.TYPE_INT_RGB));
    }
    @Test(expected = IllegalArgumentException.class)
    public void constructor_xIsNegative_IllegalArgumentException(){
        new TransformationMatrix(-15,15,3,new BufferedImage(200,100,BufferedImage.TYPE_INT_RGB));
    }
    @Test(expected = IllegalArgumentException.class)
    public void constructor_yIsNegative_IllegalArgumentException(){
        new TransformationMatrix(15,-150,3,new BufferedImage(200,100,BufferedImage.TYPE_INT_RGB));
    }
    @Test
    public void constructor_fillMatrix_corectMatrix(){
        TransformationMatrix matrix;
        BufferedImage mark=imageCreator.createEmptyBMP("",3,3).getBufferedImage();
        RGB rgb;
        int index=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
               index++;
                rgb=new RGB(index,index,index);
                mark.setRGB(j,i,rgb.getColor().getRGB());
            }
        }
        // l1 c1
        RGB[] c1=new RGB[3];
        RGB[] c2=new RGB[3];
        RGB[] c3=new RGB[3];
        c1[0]=null;
        c1[1]=null;
        c1[2]=null;
        c2[0]=null;
        c2[1]=new RGB(1,1,1);
        c2[2]=new RGB(4,4,4);
        c3[0]=null;
        c3[1]=new RGB(2,2,2);
        c3[2]=new RGB(5,5,5);
        List<RGB[]> rgbs=new ArrayList<RGB[]>();
        rgbs.add(c1);
        rgbs.add(c2);
        rgbs.add(c3);
        matrix=new TransformationMatrix(0,0,3,mark);
        for(int i=0;i<rgbs.size();i++){
            assertArrayEquals(rgbs.get(i), matrix.getcolumns().get(i));
        }
        //l2 c1
         c1=new RGB[3];
         c2=new RGB[3];
         c3=new RGB[3];
        c1[0]=null;
        c1[1]=null;
        c1[2]=null;
        c2[0]=new RGB(1,1,1);
        c2[1]=new RGB(4,4,4);
        c2[2]=new RGB(7,7,7);
        c3[0]=new RGB(2,2,2);
        c3[1]=new RGB(5,5,5);
        c3[2]=new RGB(8,8,8);
        rgbs=new ArrayList<RGB[]>();
        rgbs.add(c1);
        rgbs.add(c2);
        rgbs.add(c3);
        matrix=new TransformationMatrix(0,1,3,mark);
        for(int i=0;i<rgbs.size();i++){
            assertArrayEquals(rgbs.get(i), matrix.getcolumns().get(i));
        }
        //l3 c1
        c1=new RGB[3];
        c2=new RGB[3];
        c3=new RGB[3];
        c1[0]=null;
        c1[1]=null;
        c1[2]=null;
        c2[0]=new RGB(4,4,4);
        c2[1]=new RGB(7,7,7);
        c2[2]=null;
        c3[0]=new RGB(5,5,5);
        c3[1]=new RGB(8,8,8);
        c3[2]=null;
        rgbs=new ArrayList<RGB[]>();
        rgbs.add(c1);
        rgbs.add(c2);
        rgbs.add(c3);
        matrix=new TransformationMatrix(0,2,3,mark);
        for(int i=0;i<rgbs.size();i++){
            assertArrayEquals(rgbs.get(i), matrix.getcolumns().get(i));
        }
        //l1 c1
        c1=new RGB[3];
        c2=new RGB[3];
        c3=new RGB[3];
        c1[0]=new RGB(1,1,1);
        c1[1]=new RGB(4,4,4);
        c1[2]=new RGB(7,7,7);
        c2[0]=new RGB(2,2,2);
        c2[1]=new RGB(5,5,5);
        c2[2]=new RGB(8,8,8);
        c3[0]=new RGB(3,3,3);
        c3[1]=new RGB(6,6,6);
        c3[2]=new RGB(9,9,9);
        rgbs=new ArrayList<RGB[]>();
        rgbs.add(c1);
        rgbs.add(c2);
        rgbs.add(c3);
        matrix=new TransformationMatrix(1,1,3,mark);
        for(int i=0;i<rgbs.size();i++){
            assertArrayEquals(rgbs.get(i), matrix.getcolumns().get(i));
        }
        //l2 c2
        c1=new RGB[3];
        c2=new RGB[3];
        c3=new RGB[3];
        c1[0]=new RGB(5,5,5);
        c1[1]=new RGB(8,8,8);
        c1[2]=null;
        c2[0]=new RGB(6,6,6);
        c2[1]=new RGB(9,9,9);
        c2[2]=null;
        c3[0]=null;
        c3[1]=null;
        c3[2]=null;
        rgbs=new ArrayList<RGB[]>();
        rgbs.add(c1);
        rgbs.add(c2);
        rgbs.add(c3);
        matrix=new TransformationMatrix(2,2,3,mark);
        for(int i=0;i<rgbs.size();i++){
            assertArrayEquals(rgbs.get(i), matrix.getcolumns().get(i));
        }
    }
    @Test
    public void moveOnColumn_nextColumn_corectValue(){
        TransformationMatrix matrix;
        BufferedImage mark=imageCreator.createEmptyBMP("",3,3).getBufferedImage();
        RGB rgb;
        int index=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                index++;
                rgb=new RGB(index,index,index);
                mark.setRGB(j,i,rgb.getColor().getRGB());
            }
        }
        RGB[] c1=new RGB[3];
        RGB[] c2=new RGB[3];
        RGB[] c3=new RGB[3];
        c1[0]=null;
        c1[1]=new RGB(1,1,1);
        c1[2]=new RGB(4,4,4);
        c2[0]=null;
        c2[1]=new RGB(2,2,2);
        c2[2]=new RGB(5,5,5);
        c3[0]=null;
        c3[1]=new RGB(3,3,3);
        c3[2]=new RGB(6,6,6);
        List<RGB[]> rgbs=new ArrayList<RGB[]>();
        rgbs.add(c1);
        rgbs.add(c2);
        rgbs.add(c3);
        matrix=new TransformationMatrix(0,0,3,mark);
        matrix.moveOnColumn();
        for(int i=0;i<rgbs.size();i++){
            assertArrayEquals(rgbs.get(i), matrix.getcolumns().get(i));
        }
    }
    @Test
    public void moveOnColumn_lastColumn_doNothing(){
        TransformationMatrix matrix;
        BufferedImage mark=imageCreator.createEmptyBMP("",3,3).getBufferedImage();
        RGB rgb;
        int index=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                index++;
                rgb=new RGB(index,index,index);
                mark.setRGB(j,i,rgb.getColor().getRGB());
            }
        }
        RGB[] c1=new RGB[3];
        RGB[] c2=new RGB[3];
        RGB[] c3=new RGB[3];
        c1[0]=null;
        c1[1]=new RGB(2,2,2);
        c1[2]=new RGB(5,5,5);
        c2[0]=null;
        c2[1]=new RGB(3,3,3);
        c2[2]=new RGB(6,6,6);
        c3[0]=null;
        c3[1]=null;
        c3[2]=null;
        List<RGB[]> rgbs=new ArrayList<RGB[]>();
        rgbs.add(c1);
        rgbs.add(c2);
        rgbs.add(c3);
        matrix=new TransformationMatrix(2,0,3,mark);
        matrix.moveOnColumn();
        for(int i=0;i<rgbs.size();i++){
            assertArrayEquals(rgbs.get(i), matrix.getcolumns().get(i));
        }
    }
    @Test
    public void getColumns_AllfillFileds_numberOfFiled(){
        BufferedImage bufferedImage=imageToTest.getBlackImageToTest();
        TransformationMatrix matrix=new TransformationMatrix(1,1,smallSize,bufferedImage);
        List<RGB[]> columns = matrix.getcolumns();
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
        List<RGB[]> columns = matrix.getcolumns();
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
        List<RGB[]> columns = matrix.getcolumns();
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
        List<RGB[]> columns = matrix.getcolumns();
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