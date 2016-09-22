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
        System.out.println("IO Start");
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
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
