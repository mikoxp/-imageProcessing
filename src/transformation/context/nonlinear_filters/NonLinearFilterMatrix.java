package transformation.context.nonlinear_filters;

import image_data.RGB;
import transformation.context.TransformationMatrix;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by moles on 19.09.2016.
 * @author moles
 */
public class NonLinearFilterMatrix extends TransformationMatrix{
    private RGB rgb;
    /**
     *
     * @param x x-position
     * @param y y-position
     * @param size matrix size
     * @param bufferedImage buffor with image
     */
    public NonLinearFilterMatrix(int x, int y, int size, BufferedImage bufferedImage) {
        super(x, y, size, bufferedImage);
    }

    /**
     * method create 3 sorted list with color components (0-red,1-green,2-blue)
     * @return list with color compoments
     */
    private List<List<Integer>> extractColorComponentsValueToLists(){
        List<List<Integer>> lists=new ArrayList<List<Integer>>();
        List<Integer> red=new ArrayList<Integer>();
        List<Integer> green=new ArrayList<Integer>();
        List<Integer> blue=new ArrayList<Integer>();
        for (RGB[] column : getcolumns()) {
            for(RGB i:column){
                if(i==null){
                    continue;
                }
                red.add(i.getRed());
                green.add(i.getGreen());
                blue.add(i.getBlue());
            }
        }
        Collections.sort(red);
        Collections.sort(green);
        Collections.sort(blue);
        lists.add(red);
        lists.add(green);
        lists.add(blue);
        return lists;
    }
    /**
     *
     * @return maximal value with matrix
     */
    public Color maximalValue(){
        rgb=null;
        List<List<Integer>> colors=extractColorComponentsValueToLists();
        int i=colors.get(0).size();
       int r=colors.get(0).get(i-1);
        int g=colors.get(1).get(i-1);
        int b=colors.get(2).get(i-1);
        rgb=new RGB(r,g,b);
        return rgb.getColor();
    }

    /**
     *
     * @return minimal value with matrix
     */
    public Color minimalValue(){
        rgb=null;
        List<List<Integer>> colors=extractColorComponentsValueToLists();
        int r=colors.get(0).get(0);
        int g=colors.get(1).get(0);
        int b=colors.get(2).get(0);
        rgb=new RGB(r,g,b);
        return rgb.getColor();
    }

    /**
     *
     * @return median value with matrix
     */
    public Color  medianValue(){
        rgb=null;
        List<List<Integer>> colors=extractColorComponentsValueToLists();
        int r=0;
        int g=0;
        int b=0;
        int i=colors.get(0).size();
        if(i%2==0){
            r=(colors.get(0).get(i/2-1)+colors.get(0).get(i/2))/2;
            g=(colors.get(1).get(i/2-1)+colors.get(0).get(i/2))/2;
            b=(colors.get(2).get(i/2-1)+colors.get(0).get(i/2))/2;
        }else{
            r=colors.get(0).get(i/2);
            g=colors.get(1).get(i/2);
            b=colors.get(2).get(i/2);
        }
        rgb=new RGB(r,g,b);
        return rgb.getColor();
    }
}
