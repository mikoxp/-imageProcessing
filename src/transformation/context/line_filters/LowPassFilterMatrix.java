package transformation.context.line_filters;

import image_data.RGB;
import transformation.context.TransformationMatrix;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

/**
 * Created by moles on 21.09.2016.
 *
 * @author moles
 */
public class LowPassFilterMatrix extends TransformationMatrix {
    private Mask mask;
    private int maskSum;

    /**
     * @param line          line
     * @param column        column
     * @param mask          mask
     * @param bufferedImage bufferedImage
     */
    public LowPassFilterMatrix(int column, int line, Mask mask, BufferedImage bufferedImage) {
        super(column, line, mask.getSize(), bufferedImage);
        this.mask=mask;
        calculateMaskSum();
    }

    /**
     * Calculate mask sum
     */
    private void calculateMaskSum(){
        maskSum=0;
        int actual;
        for(int i=0;i<getSize();i++){
            for(int j=0;j<getSize();j++){
                actual=mask.getElement(j,i);
                if(actual<0){
                    throw new IllegalArgumentException("mask element can`t be negative");
                }
                maskSum+=actual;
            }
        }
        if(maskSum==0){
            throw new IllegalArgumentException("sum value in mask not be equal 0");
        }
    }
    public Color getFiltredValue() {
        List<RGB[]> rbsArray = getcolumns();
        int actualSum=0;
        RGB rgb;
        int rSum = 0;
        int gSum = 0;
        int bSum = 0;
        int size = mask.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rgb = getElement(i, j);
                if (rgb == null) {
                    continue;
                }
                actualSum+=mask.getElement(i, j);
                rSum += rgb.getRed() * mask.getElement(i, j);
                gSum += rgb.getGreen() * mask.getElement(i, j);
                bSum += rgb.getBlue() * mask.getElement(i, j);
            }
        }
        rSum/=actualSum;
        gSum/=actualSum;
        bSum/=actualSum;
        return new RGB(rSum,gSum,bSum).getColor();
    }

    public Mask getMask() {
        return mask;
    }

    public int getMaskSum() {
        return maskSum;
    }
}
