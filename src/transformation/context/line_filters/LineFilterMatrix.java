package transformation.context.line_filters;

import transformation.context.TransformationMatrix;
import transformation.context.line_filters.normalization.Normalizer;

import java.awt.image.BufferedImage;

/**
 * Created by moles on 19.09.2016.
 * @author moles
 */
public class LineFilterMatrix extends TransformationMatrix{

    private Mask mask;
    private Normalizer normalizer;

    /**
     *
     * @param line line point
     * @param column column point
     * @param bufferedImage image
     * @param mask mask
     * @param normalizer modiule normalization
     */
    public LineFilterMatrix(int line, int column,BufferedImage bufferedImage, Mask mask, Normalizer normalizer) {
        super(line, column,mask.getSize(), bufferedImage);
        if(normalizer==null){
            throw new NullPointerException("Normalizer is null");
        }
        this.mask = mask;
        this.normalizer = normalizer;
    }

}
