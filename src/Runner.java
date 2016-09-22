import image_data.ImageContainer;
import io.ImageFileManager;
import transformation.context.line_filters.LineFilterManager;
import transformation.context.line_filters.Mask;
import transformation.context.line_filters.normalization.ModuleNormalizer;
import transformation.context.line_filters.normalization.Normalizer;
import transformation.context.line_filters.normalization.ScalingNormalizer;
import transformation.context.nonlinear_filters.NonLinearFilterManager;
import transformation.context.nonlinear_filters.NonLinearFilterMatrix;
import transformation.point.Fade;
import transformation.point.PointTransformationManager;

import java.io.IOException;

public class Runner {
    private static String path = "img/lena.jpg";

    public static void main(String[] args) {
        PointTransformationManager pointTranManager=new PointTransformationManager();
        NonLinearFilterManager nonLinearFilterManager=new NonLinearFilterManager();
        LineFilterManager lineFilterManager=new LineFilterManager();

        try {
            ImageContainer imageContainer = ImageFileManager.loadFromDisk(path);
            ImageContainer max=nonLinearFilterManager.maximalValue(imageContainer,3);
            ImageFileManager.saveForDisk(max);
            ImageContainer min=nonLinearFilterManager.minimalValue(imageContainer,3);
            ImageFileManager.saveForDisk(min);
            ImageContainer median=nonLinearFilterManager.medianValue(imageContainer,3);
            ImageFileManager.saveForDisk(median);
            ImageContainer median2=nonLinearFilterManager.medianValue(imageContainer,5);
            ImageFileManager.saveForDisk(median2);
            Mask mask_average1=new Mask("mask/average1.mask");
            ImageContainer average=lineFilterManager.lowPassFilter(imageContainer,mask_average1);
            ImageFileManager.saveForDisk(average);
            Mask mask_average2=new Mask("mask/average2.mask");
            ImageContainer average2=lineFilterManager.lowPassFilter(imageContainer,mask_average2);
            ImageFileManager.saveForDisk(average2);
            Normalizer normalizer=new ModuleNormalizer();
            Mask mask_corner=new Mask("mask/corner_up_left.mask");
            ImageContainer corner=lineFilterManager.highPassFilter(imageContainer,mask_corner,normalizer);
            ImageFileManager.saveForDisk(corner);
            Mask mask_laplas=new Mask("mask/laplas4.mask");
            ImageContainer laplas=lineFilterManager.highPassFilter(imageContainer,mask_laplas,normalizer);
            ImageFileManager.saveForDisk(laplas);
            Mask mask_r1=new Mask("mask/roberts1.mask");
            ImageContainer r1=lineFilterManager.highPassFilter(imageContainer,mask_r1,normalizer);
            ImageFileManager.saveForDisk(r1);
            Mask mask_r2=new Mask("mask/roberts2.mask");
            ImageContainer r2=lineFilterManager.highPassFilter(imageContainer,mask_r2,normalizer);
            ImageFileManager.saveForDisk(r2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("DONE!!!");
    }

}
