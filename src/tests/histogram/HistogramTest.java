package tests.histogram;

import histogram.Histogram;
import image_data.ImageCreator;
import image_data.RGB;
import org.junit.Test;

import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

/**
 * Created by moles on 2016-09-24.
 * @author moles
 */
public class HistogramTest {

    @Test
    public void calculate_image_histogram_value(){
        ImageCreator imageCreator=new ImageCreator();
        BufferedImage bufferedImage=imageCreator.createEmptyBMP("",5,5).getBufferedImage();
        bufferedImage.setRGB(0,0,new RGB(255,255,255).getColor().getRGB());
        bufferedImage.setRGB(1,0,new RGB(255,255,255).getColor().getRGB());
        bufferedImage.setRGB(4,4,new RGB(125,125,125).getColor().getRGB());
        bufferedImage.setRGB(0,1,new RGB(5,5,5).getColor().getRGB());
        bufferedImage.setRGB(2,2,new RGB(5,5,5).getColor().getRGB());
        bufferedImage.setRGB(3,3,new RGB(3,3,3).getColor().getRGB());
        bufferedImage.setRGB(2,3,new RGB(3,3,3).getColor().getRGB());
        bufferedImage.setRGB(4,3,new RGB(3,3,3).getColor().getRGB());
        bufferedImage.setRGB(0,3,new RGB(3,3,3).getColor().getRGB());
        int [] mark=new int[256];
        mark[0]=16;
        mark[3]=4;
        mark[5]=2;
        mark[125]=1;
        mark[255]=2;
        Histogram histogram=new Histogram(bufferedImage);
        assertArrayEquals(mark,histogram.getRedHistogram());
        assertArrayEquals(mark,histogram.getGreenHistogram());
        assertArrayEquals(mark,histogram.getBlueHistogram());
    }

}