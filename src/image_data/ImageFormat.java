package image_data;

/**
 * Created by moles on 2016-09-09.
 * This is collection used format name
 *
 * @author moles
 */
public class ImageFormat {
    public static String[] formats = {"jpg", "bmp", "png"};
    public static String JPG = formats[0];
    public static String BMP = formats[1];
    public static String PNG = formats[2];

    /**
     * @param format image format
     * @return result
     */
    public static boolean suportedFormat(String format) {
        for (String f : formats) {
            if (format.equals(f)) {
                return true;
            }
        }
        return false;
    }
}
