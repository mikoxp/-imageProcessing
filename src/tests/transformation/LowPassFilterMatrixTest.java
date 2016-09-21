package tests.transformation;

import org.junit.Test;
import org.mockito.Mock;
import transformation.context.line_filters.LowPassFilterMatrix;
import transformation.context.line_filters.Mask;

import java.awt.image.BufferedImage;

/**
 * Created by moles on 21.09.2016.
 *
 * @author moles
 */
public class LowPassFilterMatrixTest {
    @Mock
    private Mask mask;
    @Mock
    private BufferedImage image;

    @Test(expected = NullPointerException.class)
    public void constructor_MaskIsNull_NullPointerException() {
        new LowPassFilterMatrix(0, 0, null, image);
    }

}