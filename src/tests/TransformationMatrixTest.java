package tests;

import image_data.ImageContainer;
import image_data.ImageCreator;
import image_data.RGB;
import org.junit.Test;
import transformation.TransformationMatrix;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by moles on 2016-09-18.
 * @author moles
 */
public class TransformationMatrixTest {
    private ImageCreator imageCreator = new ImageCreator();
    private final int smallSize=3;
    private BufferedImage getImageToTest(){
        ImageContainer imageContainer=imageCreator.createEmptyBMP("",100,100);
        BufferedImage bufferedImage=imageContainer.getBufferedImage();
        return bufferedImage;
    }
    @Test
    public void constructor_AllValue_corectValue(){
        BufferedImage bufferedImage=getImageToTest();
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
        BufferedImage bufferedImage=getImageToTest();
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


}