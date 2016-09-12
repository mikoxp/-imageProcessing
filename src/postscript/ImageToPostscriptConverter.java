package postscript;

import image_data.ImageContainer;
import image_data.RGB;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

/**
 * Created by moles on 2016-09-12.
 *
 * @autor moles
 */
public class ImageToPostscriptConverter {
    private final String head = "%! PS – Adobe";
    private final String setColor = "%f %f %f setrgbcolor \n";
    private final String squereDef = "/square{1 0 rlineto 0 1 rlineto -1 0 rlineto closepath} def";
    private final String squereMoveTo = "%d %d moveto square fill\n";
    private final String showPage = "showpage";
    private final String autor = "% Autor: Michal Oles, wrzesien 2016";
    private final String github = "%https://github.com/mikoxp";
    private PrintWriter writer;
    private RGB rgb;
    private int x;
    private int y;
    private int xPadding;
    private int yPadding;

    /**
     *
     */
    public ImageToPostscriptConverter() {
        xPadding = 100;
        yPadding = 100;
    }

    /**
     * @param xPadding x padding
     * @param yPadding y padding
     */
    public ImageToPostscriptConverter(int xPadding, int yPadding) {
        this.xPadding = xPadding;
        this.yPadding = yPadding;
    }

    /**
     * convert image to postscript script
     *
     * @param imageContainer conterner with image data
     */
    public void convert(ImageContainer imageContainer) {
        try {
            writer = new PrintWriter(imageContainer.getFilePath() + ".ps", "UTF-8");
            write(imageContainer.getBufferedImage(), writer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }

    /**
     * write postscript head
     *
     * @param writer writer
     */
    private void writeHead(PrintWriter writer) {
        writer.println(head);
        writer.println(autor);
        writer.println(github);
        writer.println(squereDef);
    }

    /**
     * write pixel
     *
     * @param rgb    rgb color object
     * @param pixelX x point
     * @param pixelY y point
     * @param writer writer
     */
    private void writePixel(RGB rgb, int pixelX, int pixelY, PrintWriter writer) {
        double r = (double) rgb.getRed() / 255;
        double g = (double) rgb.getGreen() / 255;
        double b = (double) rgb.getBlue() / 255;
        writer.printf(Locale.US, setColor, r, g, b);
        writer.printf(Locale.US, squereMoveTo, pixelX, pixelY);
    }

    /**
     * write end of postscript file
     *
     * @param writer writer
     */
    private void writeEnd(PrintWriter writer) {
        writer.println(showPage);
    }

    private void write(BufferedImage bufferedImage, PrintWriter printWriter) {
        writeHead(printWriter);
        x = bufferedImage.getWidth();
        for (int i = 0; i < bufferedImage.getWidth(); i++) {
            x--;
            y = bufferedImage.getHeight();
            for (int j = 0; j < bufferedImage.getHeight(); j++) {
                y--;
                rgb = new RGB(bufferedImage.getRGB(x, y));
                writePixel(rgb, i + xPadding, j + yPadding, writer);
            }
        }
        writeEnd(printWriter);
    }

}
