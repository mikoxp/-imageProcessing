package transformation.context.line_filters;

import image_data.ImageContainer;
import image_data.ImageCreator;
import transformation.context.line_filters.normalization.ModuleNormalizer;
import transformation.context.line_filters.normalization.Normalizer;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by moles on 21.09.2016.
 *
 * @author moles
 */
public class LineFilterManager {

    private HightPassFilterMatrix hightPassFilterMatrix;
    private LowPassFilterMatrix lowPassFilterMatrix;
    private ImageCreator imageCreator;
    private Color color;

    /**
     *
     */
    public LineFilterManager() {
        imageCreator = new ImageCreator();
    }

    /**
     * @param imageContainer image data
     * @param mask           mask
     * @param normalizer     normalizer
     */
    public ImageContainer highPassFilter(ImageContainer imageContainer, Mask mask, Normalizer normalizer) {
        if (normalizer == null) {
            normalizer = new ModuleNormalizer();
        }
        BufferedImage mark = imageContainer.getBufferedImage();
        String path = imageContainer.getFilePath() + "_highPassFilter" + mask.getStringMask() + "_" + normalizer.getKind();
        ImageContainer result;
        result = imageCreator.createEmpty(path, imageContainer.getImageFormat(), imageContainer.getNumberOfColumn(), imageContainer.getNumberOfLine());
        BufferedImage image = result.getBufferedImage();
        for (int i = 0; i < imageContainer.getNumberOfLine(); i++) {
            hightPassFilterMatrix = new HightPassFilterMatrix(0, i, mark, mask, normalizer);
            for (int j = 0; j < imageContainer.getNumberOfColumn(); j++) {
                //hightPassFilterMatrix = new HightPassFilterMatrix(j, i, mark, mask, normalizer);
                color = hightPassFilterMatrix.getFiltredValue();
                image.setRGB(j, i, color.getRGB());
                hightPassFilterMatrix.moveOnColumn();
            }
        }
        return result;
    }

    /**
     * @param imageContainer image data
     * @param mask           mask
     */
    public void lowPassFilter(ImageContainer imageContainer, Mask mask) {

    }
}
