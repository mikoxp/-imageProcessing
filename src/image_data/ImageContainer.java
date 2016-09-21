package image_data;

import java.awt.image.BufferedImage;

/**
 * Created by moles on 2016-09-09.
 * This is container used to save data with path and format  and easy change it
 *
 * @author moles
 */
public class ImageContainer {
    private BufferedImage bufferedImage;
    private int numberOfColumn;
    private int numberOfLine;
    private String filePath;
    private String imageFormat;

    public ImageContainer(BufferedImage bufferedImage, String filePath, String imageFormat) {
        this.bufferedImage = bufferedImage;
        this.numberOfColumn = bufferedImage.getWidth();
        this.numberOfLine = bufferedImage.getHeight();
        this.filePath = filePath;
        this.imageFormat = imageFormat;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public int getNumberOfColumn() {
        return numberOfColumn;
    }

    public void setNumberOfColumn(int numberOfColumn) {
        this.numberOfColumn = numberOfColumn;
    }

    public int getNumberOfLine() {
        return numberOfLine;
    }

    public void setNumberOfLine(int numberOfLine) {
        this.numberOfLine = numberOfLine;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getImageFormat() {
        return imageFormat;
    }

    public void setImageFormat(String imageFormat) {
        this.imageFormat = imageFormat;
    }

}
