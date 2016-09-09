package io;

import image_data.ImageContainer;
import image_data.ImageFormat;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by moles on 2016-09-09.
 */
public class ImageFileManager {

    public ImageFileManager() {
    }

    /**
     *
     * @param path file path
     * @return imageContainer
     * @throws IOException in out error
     */
    public static ImageContainer loadFromDisk(String path) throws IOException {
        BufferedImage bufferedImage= ImageIO.read(new File(path));
        String format=extractFormat(path);
        String filePath=extractPath(path,format);
        ImageContainer imageContainer=new ImageContainer(bufferedImage,filePath,format);
        return imageContainer;
    }

    /**
     *
     * @param imageContainer imageContainer
     * @throws IOException in out error
     */
    public  static void saveForDisk(ImageContainer imageContainer) throws IOException {
        BufferedImage bufferedImage=imageContainer.getBufferedImage();
        String path=imageContainer.getFilePath();
        String format=imageContainer.getImageFormat();
        File file=new File(path+"."+format);
        ImageIO.write( bufferedImage,format,file);
    }

    /**
     *
     * @param path path
     * @return file format
     */
    private static String extractFormat(String path){
        String result="";
        for(String s: ImageFormat.formats){
            if(path.indexOf("."+s)!=-1){
                result=s;
            }
        }
        if(result.equals("")){
            result="bmp";
        }
        return result;
    }

    /**
     *
     * @param path path
     * @param format format
     * @return path without file type
     */
    private static String extractPath(String path,String format){
        String result="";
        int i=path.indexOf("."+format);
        if(i!=-1){
            result=path.substring(0,i);
        }else{
            result=path.substring(0,path.indexOf("."));
        }
        return result;
    }
}
