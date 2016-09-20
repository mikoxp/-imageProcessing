package transformation.context;

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
        dataValidate(x,y,size,bufferedImage);
        this.size = size;
        this.x = x;
        this.y = y;
        this.shift=size/2;
        this.bufferedImage=bufferedImage;
        this.columns=new ArrayList<RGB[]>();
        fillMatrix();
    }
    private void dataValidate(int x, int y, int size, BufferedImage bufferedImage) throws IllegalArgumentException {
        if(x<0 || y<0){
            throw new IllegalArgumentException("negative coordinates");
        }
        if(x>=bufferedImage.getWidth() || y>=bufferedImage.getHeight()){
            throw new IllegalArgumentException("coordinates is not in image");
        }
        if(size%2==0){
            throw new IllegalArgumentException("size must be odd");
        }
    }
    /**
     * fill matrix
     */
    private void fillMatrix(){
        int startX=x-shift;
        int startY=y-shift;
        int actualX;
        RGB[] column;
        int color;
        for(i=0;i<size;i++){
            column=new RGB[size];
            actualX=startX;
            for(j=0;j<size;j++){
                try{
                    color=bufferedImage.getRGB(actualX,startY);
                    column[j]=new RGB(color);
                }catch (ArrayIndexOutOfBoundsException e){
                    column[j]=null;
                }
                actualX++;
            }
            startY++;
            columns.add(column);
        }
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
    public void nextMatrix(){
        RGB[] column=new RGB[size];
        int color;
        removeFirstColumn();
        y++;
        int startX=x-shift;
        for(j=0;j<size;j++){
            try{
                color=bufferedImage.getRGB(startX,y+1);
                column[j]=new RGB(color);
            }catch (ArrayIndexOutOfBoundsException e){
                column[j]=null;
            }
            startX++;
        }
        columns.add(column);
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
