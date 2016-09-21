import image_data.ImageContainer;
import image_data.ImageCreator;
import io.ImageFileManager;
import transformation.point.Fade;
import transformation.point.PointTransformationManager;

import java.io.IOException;

public class Runner {
    private static String path = "img/lena.bmp";

    public static void main(String[] args) {
        PointTransformationManager pointTranManager=new PointTransformationManager();
        ImageContainer pointImage;
        System.out.println("IO Start");
        try {

            //create image
            ImageCreator imageCreator = new ImageCreator();
            ImageContainer ic2;
            ic2 = imageCreator.createEmptyPNG("img/empty", 1000, 1000);
            ImageFileManager.saveForDisk(ic2);
            ic2 = imageCreator.createEmptyBMP("img/empty", 1000, 1000);
            ImageFileManager.saveForDisk(ic2);
            //negative
            ImageContainer imageContainer = ImageFileManager.loadFromDisk(path);
            pointImage=pointTranManager.negative(imageContainer);
            ImageFileManager.saveForDisk(pointImage);
            //gray scale
            imageContainer = ImageFileManager.loadFromDisk(path);
            pointImage=pointTranManager.greyScale(imageContainer);
            ImageFileManager.saveForDisk(pointImage);
            //sepia
            imageContainer = ImageFileManager.loadFromDisk(path);
            pointImage=pointTranManager.sepia(imageContainer,25);
            ImageFileManager.saveForDisk(pointImage);
            //fade red
            imageContainer = ImageFileManager.loadFromDisk(path);
            Fade fade=new Fade(true,false,false);
            pointImage=pointTranManager.fadeColor(imageContainer,fade);
            ImageFileManager.saveForDisk(pointImage);
            //fade green
            imageContainer = ImageFileManager.loadFromDisk(path);
            fade=new Fade(false,true,false);
            pointImage=pointTranManager.fadeColor(imageContainer,fade);
            ImageFileManager.saveForDisk(pointImage);
            //fade blue
            imageContainer = ImageFileManager.loadFromDisk(path);
            fade=new Fade(false,false,true);
            pointImage=pointTranManager.fadeColor(imageContainer,fade);
            ImageFileManager.saveForDisk(pointImage);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
