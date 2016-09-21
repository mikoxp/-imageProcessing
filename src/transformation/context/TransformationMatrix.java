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
    private int lastColumn;
    private int i,j;

    /**
     *
     * @param line line-position
     * @param column column-position
     * @param size matrix size
     * @param bufferedImage buffor with image
     */
    public TransformationMatrix(int column, int line, int size, BufferedImage bufferedImage) {
        if(bufferedImage==null){
            throw new NullPointerException("BufforedIamge is null");
        }
        dataValidate(line, column, size, bufferedImage);
        this.lastColumn=bufferedImage.getWidth()-1;
        this.size = size;
        this.line = line;
        this.column = column;
        this.shift=size/2;
        this.bufferedImage=bufferedImage;
        this.rGBcolumns = new ArrayList<RGB[]>();
        fillMatrix();
    }
    private void dataValidate(int line, int column, int size, BufferedImage bufferedImage) throws IllegalArgumentException {
        if(line<0 || column<0){
            throw new IllegalArgumentException("negative coordinates");
        }
        if(line>=bufferedImage.getHeight() || column>=bufferedImage.getWidth()){
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
        RGB[] oneRGBColumn;
        int color;
        int startLine=line-shift;
        int startColumn=column-shift;
        int actualLine;
        for(i=0;i<size;i++){
            oneRGBColumn=new RGB[size];
            actualLine=startLine;
            for(j=0;j<size;j++){
                try {
                    color = bufferedImage.getRGB(startColumn, actualLine);
                    oneRGBColumn[j] = new RGB(color);
                }catch (ArrayIndexOutOfBoundsException e){
                    oneRGBColumn[j]=null;
                }
                actualLine++;
            }
            startColumn++;
            rGBcolumns.add(oneRGBColumn);
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
    public void moveOnColumn(){
        if(column==lastColumn){
            return;
        }
        RGB[] rgbColumn = new RGB[size];
        int color;
        removeFirstColumn();
        column++;
        int startX = line - shift;
        for(j=0;j<size;j++){
            try{
                color = bufferedImage.getRGB(column + 1,startX);
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

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }
}
