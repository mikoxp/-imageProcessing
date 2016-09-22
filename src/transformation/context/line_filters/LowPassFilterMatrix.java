package transformation.context.line_filters;

import transformation.context.TransformationMatrix;

import java.awt.*;
import java.awt.image.BufferedImage;

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
        return null;
    }

    public Mask getMask() {
        return mask;
    }

    public int getMaskSum() {
        return maskSum;
    }
}
