package transformation.context.line_filters.normalization;

import image_data.RGB;
import transformation.context.TransformationMatrix;
import transformation.context.line_filters.Mask;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by moles on 20.09.2016.
 * @author moles
 */
public class ScalingNormalizer implements Normalizer{
    private NormalizerRange redRange;
    private NormalizerRange greenRange;
    private NormalizerRange blueRange;

    /**
     *
     * @param redRange range red part
     * @param greenRange range green part
     * @param blueRange range blue part
     */
    public ScalingNormalizer(NormalizerRange redRange, NormalizerRange greenRange, NormalizerRange blueRange) {
        this.redRange = redRange;
        this.greenRange = greenRange;
        this.blueRange = blueRange;
        if(redRange==null){
            this.redRange=new NormalizerRange();
        }
        if(greenRange==null){
            this.greenRange=new NormalizerRange();
        }
        if(blueRange==null){
            this.blueRange=new NormalizerRange();
        }
    }

    /**
     *
     * @param bufferedImage image
     * @param mask mask
     */
    public ScalingNormalizer(BufferedImage bufferedImage, Mask mask) {
       redRange =new NormalizerRange();
        greenRange =new NormalizerRange();
        blueRange =new NormalizerRange();
        searchRanges(bufferedImage,mask);
    }

    /**
     *
     * @param bufferedImage bufforedImage
     * @param mask mask
     */
    private void searchRanges(BufferedImage bufferedImage, Mask mask){
        int size=mask.getSize();
        TransformationMatrix matrix;
        for(int i=0;i<bufferedImage.getHeight();i++){
            matrix=new TransformationMatrix(i,0,size,bufferedImage);
            for(int j=0;j<bufferedImage.getWidth();j++){
                comparePointValue(matrix,mask);
                matrix.nextMatrix();
            }
        }
    }

    /**
     *
     * @param matrix matrix
     * @param mask mask
     */
    private void comparePointValue(TransformationMatrix matrix,Mask mask){
        RGB rgb;
        int rSum=0;
        int gSum=0;
        int bSum=0;
        int size=mask.getSize();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                rgb=matrix.getElement(i,j);
                if(rgb==null){
                    continue;
                }
                rSum+=rgb.getRed()*mask.getElement(i,j);
                gSum+=rgb.getGreen()*mask.getElement(i,j);
                bSum+=rgb.getBlue()*mask.getElement(i,j);
            }
        }
        if(rSum> redRange.getMax()){
            redRange.setMax(rSum);
        }
        if(rSum< redRange.getMin()){
            redRange.setMin(rSum);
        }
        if(gSum> greenRange.getMax()){
            greenRange.setMax(gSum);
        }
        if(gSum< greenRange.getMin()){
            greenRange.setMin(gSum);
        }
        if(bSum> blueRange.getMax()){
            blueRange.setMax(bSum);
        }
        if(bSum< blueRange.getMin()){
            blueRange.setMin(bSum);
        }

    }

    public NormalizerRange getRedRange() {
        return redRange;
    }

    public NormalizerRange getGreenRange() {
        return greenRange;
    }

    public NormalizerRange getBlueRange() {
        return blueRange;
    }

    /**
     * @param red   redRange part color before normalization
     * @param green greenRange part color before normalization
     * @param blue  blueRange part color before normalization
     * @return Color after normalization
     */
    public Color normalizing(int red, int green, int blue) {
        int r=(red-redRange.getMin())*255/(redRange.getMax()-redRange.getMin());
        int g=(green-greenRange.getMin())*255/(greenRange.getMax()-greenRange.getMin());
        int b=(blue-blueRange.getMin())*255/(blueRange.getMax()-blueRange.getMin());
        RGB rgb=new RGB(r,g,b);
        return rgb.getColor();
    }
}
