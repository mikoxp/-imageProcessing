package transformation.context.line_filters;

import transformation.context.TransformationMatrix;

import java.awt.image.BufferedImage;

/**
 * Created by moles on 21.09.2016.
 *
 * @author moles
 */
public class LowPassFilterMatrix extends TransformationMatrix {
    private Mask mask;

    /**
     * @param line          line
     * @param column        column
     * @param mask          mask
     * @param bufferedImage bufferedImage
     */
    public LowPassFilterMatrix(int line, int column, Mask mask, BufferedImage bufferedImage) {
        super(line, column, mask.getSize(), bufferedImage);
    }
}
