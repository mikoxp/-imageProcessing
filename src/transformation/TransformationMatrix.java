package transformation;

import image_data.RGB;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
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
    private int i,j;

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
        this.columns=new ArrayList<RGB[]>();
        fillMatrix();
    }

    /**
     * fill matrix
     */
    private void fillMatrix(){
        int startX=x-shift;
        int startY=y-shift;
        int endX=x+shift;
        int endY=y+shift;
        int index;
        RGB[] column;
        int color;
        for(j=startY;j<=endY;j++){
            index=0;
            column=new RGB[size];
            for(i=startX;i<=endX;i++){
                try{
                    color=bufferedImage.getRGB(i,j);
                    column[index]=new RGB(color);
                }catch (ArrayIndexOutOfBoundsException e){
                    column[index]=null;
                }
                index++;
            }
            columns.add(column);
        }
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransformationMatrix that = (TransformationMatrix) o;

        if (size != that.size) return false;
        return columns.equals(that.columns);

    }

    @Override
    public int hashCode() {
        int result = size;
        result = 31 * result + columns.hashCode();
        return result;
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
