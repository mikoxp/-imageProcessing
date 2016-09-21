package transformation.context.line_filters;

import image_data.RGB;
import transformation.context.TransformationMatrix;
import transformation.context.line_filters.normalization.Normalizer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Created by moles on 19.09.2016.
 * @author moles
 */
public class HightPassFilterMatrix extends TransformationMatrix {

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
    public HightPassFilterMatrix(int line, int column, BufferedImage bufferedImage, Mask mask, Normalizer normalizer) {
        super(line, column,mask.getSize(), bufferedImage);
        if(normalizer==null){
            throw new NullPointerException("Normalizer is null");
        }
        this.mask = mask;
        this.normalizer = normalizer;
    }

    public Color getFiltredValue() {
        List<RGB[]> rbsArray = getcolumns();
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
                rSum += rgb.getRed() * mask.getElement(i, j);
                gSum += rgb.getGreen() * mask.getElement(i, j);
                bSum += rgb.getBlue() * mask.getElement(i, j);
            }
        }
        return normalizer.normalizing(rSum, gSum, bSum);
    }


}
