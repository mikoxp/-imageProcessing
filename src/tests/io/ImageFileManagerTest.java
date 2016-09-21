package tests.io;


import com.sun.javaws.exceptions.InvalidArgumentException;
import io.ImageFileManager;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by moles on 2016-09-10.
 *
 * @author moles
 */
public class ImageFileManagerTest {
    @Test()
    public void extractFormat_pathIsCorrect_format() {
        String format;
        String pathJpg = "img/lena.jpg";
        format = ImageFileManager.extractFormat(pathJpg);
        Assert.assertEquals("jpg", format);
        //_______________________________________
        String pathPng = "img/lena.png";
        format = ImageFileManager.extractFormat(pathPng);
        Assert.assertEquals("png", format);
    }
    @Test
    public void extractFormat_pathIsNotRecognise_bmpFormat() {
        String format;
        String path = "img/lena.txt";
        format = ImageFileManager.extractFormat(path);
        Assert.assertEquals("bmp", format);

    }

    @Test(expected = IllegalArgumentException.class)
    public void extractFormat_pathIsNull_InllegalArgumentException() {
        ImageFileManager.extractFormat(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void extractFormat_pathIsEmptyString_InllegalArgumentException() {
        ImageFileManager.extractFormat("");
    }

    @Test
    public void extractPathWithOutFormat_AllCorect_pathWithOutFormat() throws InvalidArgumentException {
        String pathJpg = "img/lena.jpg";
        String without = ImageFileManager.extractPathWithOutFormat(pathJpg, "jpg");
        Assert.assertEquals("img/lena", without);
    }

    @Test(expected = IllegalArgumentException.class)
    public void extractPathWithOutFormat_pathIsNull_InllegalArgumentException() throws InvalidArgumentException {
        ImageFileManager.extractPathWithOutFormat(null, "jpg");
    }

    @Test(expected = IllegalArgumentException.class)
    public void extractPathWithOutFormat_pathIsEmptyString_InllegalArgumentException() throws InvalidArgumentException {
        ImageFileManager.extractPathWithOutFormat("", "jpg");
    }

    @Test(expected = IllegalArgumentException.class)
    public void extractPathWithOutFormat_formatIsNull_InllegalArgumentException() throws InvalidArgumentException {
        String pathJpg = "img/lena.jpg";
        ImageFileManager.extractPathWithOutFormat(pathJpg, null);
    }

    @Test(expected = InvalidArgumentException.class)
    public void extractPathWithOutFormat_notFoundFormatInPath_InwalidArgumentException() throws InvalidArgumentException {
        String pathJpg = "img/lena.jpg";
        String without = ImageFileManager.extractPathWithOutFormat(pathJpg, "png");
        Assert.assertEquals("img/lena", without);
    }

    @Test
    public void extractPathWithOutFormat_formatIsEmptyAndIsPoint() throws InvalidArgumentException {
        String pathJpg = "img/lena.jpg";
        String p = ImageFileManager.extractPathWithOutFormat(pathJpg, "");
        Assert.assertEquals("img/lena", p);
    }

    @Test
    public void extractPathWithOutFormat_formatIsEmptyAndIsNotPoint() throws InvalidArgumentException {
        String pathJpg = "img/lena";
        String p = ImageFileManager.extractPathWithOutFormat(pathJpg, "");
        Assert.assertEquals("img/lena", p);
    }


}