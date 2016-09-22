import image_data.ImageContainer;
import io.ImageFileManager;
import transformation.context.line_filters.LineFilterManager;
import transformation.context.line_filters.Mask;
import transformation.context.line_filters.normalization.ModuleNormalizer;
import transformation.context.line_filters.normalization.Normalizer;
import transformation.context.line_filters.normalization.ScalingNormalizer;
import transformation.point.Fade;
import transformation.point.PointTransformationManager;

import java.io.IOException;

public class Runner {
    private static String path = "img/lena.jpg";

    public static void main(String[] args) {
        PointTransformationManager pointTranManager=new PointTransformationManager();
        ImageContainer pointImage;
        System.out.println("IO Start");
        try {
            ImageContainer imageContainer = ImageFileManager.loadFromDisk(path);
            //negative
            pointImage = pointTranManager.negative(imageContainer);
            ImageFileManager.saveForDisk(pointImage);
            //gray scale
            pointImage = pointTranManager.greyScale(imageContainer);
            ImageFileManager.saveForDisk(pointImage);
            //sepia
            pointImage = pointTranManager.sepia(imageContainer, 25);
            ImageFileManager.saveForDisk(pointImage);
            //fade red
            Fade fade = new Fade(true, false, false);
            pointImage = pointTranManager.fadeColor(imageContainer, fade);
            ImageFileManager.saveForDisk(pointImage);
            //fade green
            fade = new Fade(false, true, false);
            pointImage = pointTranManager.fadeColor(imageContainer, fade);
            ImageFileManager.saveForDisk(pointImage);
            //fade blue
            fade = new Fade(false, false, true);
            pointImage = pointTranManager.fadeColor(imageContainer, fade);
            ImageFileManager.saveForDisk(pointImage);

            Mask mask = new Mask("mask/prewitt_vertical.mask");
            LineFilterManager lineFilterManager = new LineFilterManager();
            ImageContainer con = ImageFileManager.loadFromDisk(path);
            Normalizer normalizer = new ScalingNormalizer(con.getBufferedImage(), mask);
            ImageContainer container = lineFilterManager.highPassFilter(con, mask, normalizer);
            ImageFileManager.saveForDisk(container);
            container = lineFilterManager.highPassFilter(con, mask, new ModuleNormalizer());
            ImageFileManager.saveForDisk(container);

            Mask mask2 = new Mask("mask/prewitt_horizontal.mask");
            ImageContainer con2 = ImageFileManager.loadFromDisk(path);
            normalizer = new ScalingNormalizer(con2.getBufferedImage(), mask2);
            ImageContainer container2 = lineFilterManager.highPassFilter(con2, mask2, normalizer);
            ImageFileManager.saveForDisk(container2);
            container2 = lineFilterManager.highPassFilter(con2, mask2, new ModuleNormalizer());
            ImageFileManager.saveForDisk(container2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
