package image_data;

import java.awt.image.BufferedImage;

/**
 * Created by moles on 2016-09-09.
 *
 * @author moles
 */
public class ImageCreator {
    /**
     * image is transparent
     *
     * @param path   path
     * @param numberOfColumn  numberOfColumn
     * @param numberOfLine numberOfLine
     * @return create iamge
     */
    public ImageContainer createEmptyPNG(String path, int numberOfColumn, int numberOfLine) {
        BufferedImage empty = new BufferedImage(numberOfColumn, numberOfLine, BufferedImage.TYPE_INT_ARGB);
        return new ImageContainer(empty, path, ImageFormat.PNG);
    }

    /**
     * image is not transparent
     *
     * @param path   path
     * @param numberOfColumn  numberOfColumn
     * @param numberOfLine numberOfLine
     * @return create iamge
     */
    public ImageContainer createEmptyBMP(String path, int numberOfColumn, int numberOfLine) {
        BufferedImage empty = new BufferedImage(numberOfColumn, numberOfLine, BufferedImage.TYPE_INT_RGB);
        return new ImageContainer(empty, path, ImageFormat.BMP);
    }

    /**
     * @param path           path
     * @param format         image format
     * @param numberOfColumn number of column
     * @param numberOfLine   number of line
     * @return create image
     */
    public ImageContainer createEmpty(String path, String format, int numberOfColumn, int numberOfLine) {
        format = ImageFormat.suportedFormat(format) ? format : ImageFormat.BMP;
        BufferedImage empty = new BufferedImage(numberOfColumn, numberOfLine, BufferedImage.TYPE_INT_RGB);
        return new ImageContainer(empty, path, format);
    }

}
