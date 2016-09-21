package transformation.context.line_filters;

import image_data.ImageContainer;
import transformation.context.line_filters.normalization.ModuleNormalizer;
import transformation.context.line_filters.normalization.Normalizer;

import java.awt.image.BufferedImage;

/**
 * Created by moles on 21.09.2016.
 *
 * @author moles
 */
public class LineFilterManager {

    private HightPassFilterMatrix hightPassFilterMatrix;
    private LowPassFilterMatrix lowPassFilterMatrix;
    /**
     *
     * @param imageContainer image data
     * @param mask mask
     * @param normalizer normalizer
     * @return filtred image data
     */
    public ImageContainer highPassFilter(ImageContainer imageContainer, Mask mask, Normalizer normalizer){
       if(normalizer==null){
           normalizer=new ModuleNormalizer();
       }
       BufferedImage bufferedImage=imageContainer.getBufferedImage();
       hightPassFilterMatrix=new HightPassFilterMatrix(0,0,bufferedImage,mask,normalizer);
        //for(int i=0;i<imageContainer.get)
    }

    /**
     *
     * @param imageContainer image data
     * @param mask mask
     * @return filtred image data
     */
    public ImageContainer lowPassFilter(ImageContainer imageContainer,Mask mask){
        return null;
    }
}
