package com.web.springbootproject.util;

import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class ImageUtils {
    public static byte[] compressImage(byte[] image){
        Deflater deflater = new Deflater();
        deflater.setLevel(Deflater.BEST_COMPRESSION);
        deflater.setInput(image);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(image.length);
        byte[] tmp = new byte[4*1024];
        while (!deflater.finished()){
            int size = deflater.deflate(tmp);
            outputStream.write(tmp,0,size);
        }
        try {
            outputStream.close();
        }catch (Exception ignored){

        }
        return  outputStream.toByteArray();
    }

    public static byte[] decompressImage(byte[] imageCompressed){
        Inflater inflater = new Inflater();
        inflater.setInput(imageCompressed);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(imageCompressed.length);
        byte[] tmp = new byte[4*1024];

        try {
            while (!inflater.finished()){
                int count = inflater.inflate(tmp);
                outputStream.write(tmp,0,count);
            }
            outputStream.close();
        }catch (Exception ignored){

        }
        return  outputStream.toByteArray();
    }
}
