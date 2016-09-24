import gui.histogram.HistogramGui;
import image_data.ImageContainer;
import io.ImageFileManager;

import java.io.IOException;

public class Runner {
    private static String path = "img/lena.jpg";

    public static void main(String[] args) {

        try {
            ImageContainer imageContainer= ImageFileManager.loadFromDisk(path);

        HistogramGui.setBufferedImage(imageContainer.getBufferedImage());
            new HistogramGui().showHistogram();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("DONE!!!");
    }

}
