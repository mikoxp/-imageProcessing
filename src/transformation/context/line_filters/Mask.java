package transformation.context.line_filters;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by moles on 19.09.2016.
 * @author moles
 */
public class Mask {
    int size;
    int[][] values;

    /**
     *
     * @param values values [column][line]
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

    public Mask(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        Scanner scanner = new Scanner(fileReader);
        size = scanner.nextInt();
        values = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                values[j][i] = scanner.nextInt();
            }
        }
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
    public int getElement(int column, int line) {
        if (line >= size || column >= size) {
            throw new IllegalArgumentException("wrong coordinate");
        }
        return values[column][line];
    }

    /**
     * @return value of mask in stringData
     */
    public String getStringMask() {
        String txt = "";
        for (int i = 0; i < size; i++) {
            txt += "_";
            for (int j = 0; j < size; j++) {
                txt += " " + values[j][i] + "";
            }
        }
        return txt;
    }

    /**
     * @param path file path
     */
    public void saveToFile(String path) throws IOException {
        PrintWriter writer = new PrintWriter(path, "UTF-8");
        writer.println(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                writer.print(values[j][i] + " ");
            }
            writer.print("\n");
        }
        writer.close();
    }
}
