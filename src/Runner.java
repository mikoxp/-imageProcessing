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
            ic.setImageFormat(ImageFormat.PNG);
            ImageFileManager.saveForDisk(ic);
            //create image
            ImageCreator imageCreator = new ImageCreator();
            ImageContainer ic2;
            ic2 = imageCreator.createEmptyPNG("img/empty", 1000, 1000);
            ImageFileManager.saveForDisk(ic);
            ic2 = imageCreator.createEmptyBMP("img/empty", 1000, 1000);
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
