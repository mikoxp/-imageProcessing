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
    private List<RGB[]> rGBcolumns;
    private int line; //x-position
    private int column; //y-position
    private BufferedImage bufferedImage; //image
    private int shift;
    private int i,j;

    /**
     *
     * @param line line-position
     * @param column column-position
     * @param size matrix size
     * @param bufferedImage buffor with image
     */
    public TransformationMatrix(int line, int column, int size, BufferedImage bufferedImage) {
        dataValidate(line, column, size, bufferedImage);
        this.size = size;
        this.line = line;
        this.column = column;
        this.shift=size/2;
        this.bufferedImage=bufferedImage;
        this.rGBcolumns = new ArrayList<RGB[]>();
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
        int startX = line - shift;
        int startY = column - shift;
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
            rGBcolumns.add(column);
        }
    }

    /**
     * remove first column
     */
    private void removeFirstColumn(){
        rGBcolumns.remove(0);
    }

    /**
     * moves the value of one column
     */
    public void nextMatrix(){
        RGB[] rgbColumn = new RGB[size];
        int color;
        removeFirstColumn();
        column++;
        int startX = line - shift;
        for(j=0;j<size;j++){
            try{
                color = bufferedImage.getRGB(startX, column + 1);
                rgbColumn[j] = new RGB(color);
            }catch (ArrayIndexOutOfBoundsException e){
                rgbColumn[j] = null;
            }
            startX++;
        }
        rGBcolumns.add(rgbColumn);
    }

    public int getSize() {
        return size;
    }

    public List<RGB[]> getcolumns() {
        return rGBcolumns;
    }

    /**
     *
     * @param line line
     * @param column column
     * @return element
     */
    public RGB getElement(int line,int column){
        if(line<0 || line>=size || column<0|| column>=size){
            throw new IllegalArgumentException("Incorect Coordinate");
        }
        return rGBcolumns.get(column)[line];
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
        return rGBcolumns.equals(that.rGBcolumns);

    }

    @Override
    public int hashCode() {
        int result = size;
        result = 31 * result + rGBcolumns.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TransformationMatrix{" +
                "size=" + size +
                ", rGBcolumns=" + rGBcolumns +
                ", line=" + line +
                ", y=" + column +
                '}';
    }
}
