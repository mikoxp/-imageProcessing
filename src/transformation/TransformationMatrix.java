package transformation;

import image_data.RGB;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Created by moles on 2016-09-18.
 * @author moles
 */
public class TransformationMatrix {
    private int size;//size matrix
    private List<RGB[]> columns;
    private int x; //x-position
    private int y; //y-position
    private BufferedImage bufferedImage; //image
    private int shift;

    /**
     *
     * @param x x-position
     * @param y y-position
     * @param size matrix size
     * @param bufferedImage buffor with image
     */
    public TransformationMatrix(int x, int y, int size, BufferedImage bufferedImage) {
        this.size = size;
        this.x = x;
        this.y = y;
        this.shift=size/2;
        this.bufferedImage=bufferedImage;
        fillMatrix();
    }

    /**
     * fill matrix
     */
    private void fillMatrix(){
        int startX=x-shift;
        int startY=y-shift;
    }
    /**
     * add column
     * @param column column
     */
    private void addColumn(RGB[] column){
        columns.add(column);
    }

    /**
     * remove first column
     */
    private void removeFirstColumn(){
        columns.remove(0);
    }

    /**
     * moves the value of one column
     */
    private void nextMatrix(){

    }

    public int getSize() {
        return size;
    }

    public List<RGB[]> getColumns() {
        return columns;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    @Override
    public String toString() {
        return "TransformationMatrix{" +
                "size=" + size +
                ", columns=" + columns +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
