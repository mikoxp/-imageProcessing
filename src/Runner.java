import image_data.ImageContainer;
import io.ImageFileManager;
import transformation.context.line_filters.LineFilterManager;
import transformation.context.line_filters.Mask;
import transformation.context.line_filters.normalization.Normalizer;
import transformation.context.line_filters.normalization.ScalingNormalizer;
import transformation.point.PointTransformationManager;

import java.io.IOException;

public class Runner {
    private static String path = "img/lena.jpg";

    public static void main(String[] args) {
        PointTransformationManager pointTranManager=new PointTransformationManager();
        ImageContainer pointImage;
        System.out.println("IO Start");
        try {
//            //negative
//            ImageContainer imageContainer = ImageFileManager.loadFromDisk(path);
//            pointImage=pointTranManager.negative(imageContainer);
//            ImageFileManager.saveForDisk(pointImage);
//            //gray scale
//            imageContainer = ImageFileManager.loadFromDisk(path);
//            pointImage=pointTranManager.greyScale(imageContainer);
//            ImageFileManager.saveForDisk(pointImage);
//            //sepia
//            imageContainer = ImageFileManager.loadFromDisk(path);
//            pointImage=pointTranManager.sepia(imageContainer,25);
//            ImageFileManager.saveForDisk(pointImage);
//            //fade red
//            imageContainer = ImageFileManager.loadFromDisk(path);
//            Fade fade=new Fade(true,false,false);
//            pointImage=pointTranManager.fadeColor(imageContainer,fade);
//            ImageFileManager.saveForDisk(pointImage);
//            //fade green
//            imageContainer = ImageFileManager.loadFromDisk(path);
//            fade=new Fade(false,true,false);
//            pointImage=pointTranManager.fadeColor(imageContainer,fade);
//            ImageFileManager.saveForDisk(pointImage);
//            //fade blue
//            imageContainer = ImageFileManager.loadFromDisk(path);
//            fade=new Fade(false,false,true);
//            pointImage=pointTranManager.fadeColor(imageContainer,fade);
//            ImageFileManager.saveForDisk(pointImage);
            int[][] value = new int[3][3];
            value[0][0] = -1;
            value[0][1] = -1;
            value[0][2] = -1;
            value[2][0] = 1;
            value[2][1] = 1;
            value[2][2] = 1;
            Mask mask = new Mask(value);
            LineFilterManager lineFilterManager = new LineFilterManager();
            ImageContainer con = ImageFileManager.loadFromDisk(path);
            Normalizer normalizer = new ScalingNormalizer(con.getBufferedImage(), mask);
            con = lineFilterManager.highPassFilter(con, mask, normalizer);
            ImageFileManager.saveForDisk(con);
            value = new int[3][3];
            value[0][0] = -1;
            value[1][0] = -1;
            value[2][0] = -1;
            value[0][2] = 1;
            value[1][2] = 1;
            value[2][2] = 1;
            Mask mask2 = new Mask(value);
            ImageContainer con2 = ImageFileManager.loadFromDisk(path);
            normalizer = new ScalingNormalizer(con2.getBufferedImage(), mask2);
            con2 = lineFilterManager.highPassFilter(con2, mask2, normalizer);
            ImageFileManager.saveForDisk(con2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
