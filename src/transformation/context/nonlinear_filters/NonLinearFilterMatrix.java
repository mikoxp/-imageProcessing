package transformation.context.nonlinear_filters;

import transformation.context.TransformationMatrix;

import java.awt.image.BufferedImage;

/**
 * Created by moles on 19.09.2016.
 * @author moles
 */
public class NonLinearFilterMatrix extends TransformationMatrix{
    /**
     *
     * @param x x-position
     * @param y y-position
     * @param size matrix size
     * @param bufferedImage buffor with image
     */
    public NonLinearFilterMatrix(int x, int y, int size, BufferedImage bufferedImage) {
        super(x, y, size, bufferedImage);
    }
}
