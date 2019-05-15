package com.zz.test;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {

    public static void main(String[] args) throws IOException {
        File file_d = new File("D:\\a.txt");
        File file_e = new File("E:\\a.txt");
        FileInputStream is = new FileInputStream(file_d);
        FileOutputStream os = new FileOutputStream(file_e);
        int len = is.available();
        byte[] a = new byte[100];
        for (int i = 0; i < len; i++) {
            is.read(a);
        }
        os.write(a);
        is.close();
        os.close();
    }

}