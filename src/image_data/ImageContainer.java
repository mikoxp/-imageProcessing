package image_data;

import java.awt.image.BufferedImage;

/**
 * Created by moles on 2016-09-09.
 * This is container used to save data with path and format  and easy change it
 * @author moles
 */
public class ImageContainer {
    private BufferedImage bufferedImage;
    private int width;
    private int height;
    private String filePath;
    private String imageFormat;

    public ImageContainer(BufferedImage bufferedImage,String filePath, String imageFormat) {
        this.bufferedImage = bufferedImage;
        this.width = bufferedImage.getWidth();
        this.height = bufferedImage.getHeight();
        this.filePath = filePath;
        this.imageFormat = imageFormat;
    }
    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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
