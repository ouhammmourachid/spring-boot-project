package com.web.springbootproject.util;

import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class FileUtils {
    public static byte[] compressImage(byte[] file){
        Deflater deflater = new Deflater();
        deflater.setLevel(Deflater.BEST_COMPRESSION);
        deflater.setInput(file);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(file.length);
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

    public static byte[] decompressImage(byte[] fileCompressed){
        Inflater inflater = new Inflater();
        inflater.setInput(fileCompressed);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(fileCompressed.length);
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
