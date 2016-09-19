package transformation.context.line_filters;

/**
 * Created by moles on 19.09.2016.
 * @author moles
 */
public class Mask {
    int size;
    int[][] values;

    /**
     *
     * @param values values
     */
    public Mask(int[][] values) {
        if(values.length!=values[0].length){
            throw new IllegalArgumentException("matrix must be square");
        }
        if(values.length%2==0){
            throw new IllegalArgumentException("size must be odd");
        }
        this.values = values;
        size=values.length;
    }

    /**
     *
     * @param width width
     * @param height height
     * @return element mask
     */
    public int getElement(int width,int height){
        if(width>=size || height>=size){
            throw new IllegalArgumentException("wrong coordinate");
        }
        return values[width][height];
    }
}
