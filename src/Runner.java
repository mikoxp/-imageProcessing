import image_data.ImageContainer;
import image_data.ImageCreator;
import image_data.ImageFormat;
import io.ImageFileManager;
import postscript.ImageToPostscriptConverter;

import java.io.IOException;

public class Runner {
    private static String path = "img/lena.bmp";

    public static void main(String[] args) {
        System.out.println("IO Start");
        try {
            //open image
            ImageContainer ic = ImageFileManager.loadFromDisk(path);
            System.out.println("Path: " + ic.getFilePath());
            System.out.println("Format: " + ic.getImageFormat());
            System.out.println("Width: " + ic.getWidth());
            System.out.println("Height: " + ic.getHeight());
            ic.setImageFormat(ImageFormat.PNG);
            ImageFileManager.saveForDisk(ic);
            //create image
            ImageCreator imageCreator = new ImageCreator();
            ic = imageCreator.createEmptyPNG("img/empty", 1000, 1000);
            ImageFileManager.saveForDisk(ic);
            ic = imageCreator.createEmptyBMP("img/empty", 1000, 1000);
            ImageFileManager.saveForDisk(ic);
            //to postscript
//            ImageContainer imageContainer = ImageFileManager.loadFromDisk(path);
//            ImageToPostscriptConverter imageToPostscriptConverter = new ImageToPostscriptConverter();
//            imageToPostscriptConverter.convert(imageContainer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
