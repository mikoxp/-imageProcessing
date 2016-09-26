import image_data.ImageContainer;
import image_data.RGB;
import io.ImageFileManager;
import transformation.binarization.Binarization;

import java.io.IOException;

public class Runner {
    private static String path = "img/lena.jpg";

    public static void main(String[] args) {
        Binarization binarization=new Binarization();
        try {

            ImageContainer imageContainer= ImageFileManager.loadFromDisk(path);
            ImageContainer image=binarization.lowerThreshold(imageContainer,new RGB(200,200,250));
           ImageFileManager.saveForDisk(image);
            ImageContainer image2=binarization.upperThreshold(imageContainer,new RGB(125,125,125));
            ImageFileManager.saveForDisk(image2);
            ImageContainer image3=binarization.doubleThreshold(imageContainer,new RGB(100,100,100),new RGB(105,105,105));
            ImageFileManager.saveForDisk(image3);
        }catch (IOException e){

        }

        System.out.println("DONE!!!");
    }

}
