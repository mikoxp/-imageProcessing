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
     * @param values values [line][column]
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

    public int getSize() {
        return size;
    }

    /**
     *
     * @param line line
     * @param column column
     * @return element mask
     */
    public int getElement(int line, int column) {
        if (line >= size || column >= size) {
            throw new IllegalArgumentException("wrong coordinate");
        }
        return values[line][column];
    }
}
