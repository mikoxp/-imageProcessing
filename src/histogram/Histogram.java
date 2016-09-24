package histogram;

import image_data.RGB;

import java.awt.image.BufferedImage;

/**
 * Created by moles on 2016-09-24.
 * @author moles
 */
public class Histogram {
    private int[] redHistogram;
    private int[] greenHistogram;
    private int[] blueHistogram;


    /**
     *
     * @param bufferedImage bufferedImage
     */
    public Histogram(BufferedImage bufferedImage) {
        this.redHistogram=new int[256];
        this.greenHistogram=new int[256];
        this.blueHistogram=new int[256];
        calculateHistogram(bufferedImage);
    }

    public int[] getRedHistogram() {
        return redHistogram;
    }

    public int[] getGreenHistogram() {
        return greenHistogram;
    }

    public int[] getBlueHistogram() {
        return blueHistogram;
    }

    /**
     * calculate histogram
     */
    private void calculateHistogram(BufferedImage bufferedImage){
        RGB rgb;
        for(int i=0;i<bufferedImage.getWidth();i++){
            for(int j=0;j<bufferedImage.getHeight();j++){
                rgb=new RGB(bufferedImage.getRGB(i,j));
                redHistogram[rgb.getRed()]++;
                greenHistogram[rgb.getGreen()]++;
                blueHistogram[rgb.getBlue()]++;
            }
        }
    }
}
