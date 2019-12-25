package com.sk.io;

import java.io.File;
import java.io.IOException;

/**
 * @author sk
 * create on  2019/12/21:22:02
 */
public class TestFile {
    public static void main(String[] args) throws IOException {
        String path = "D:/src/daydayup/study/src/images/bj.jpg";

        File file = new File(path);
        System.out.println(file.length());
        file = new File("D:/src/daydayup/study/src/","images/bj.jpg");
        System.out.println(file.length());
        file = new File(new File("D:/src/daydayup/study/src/"),"images/bj.jpg");
        System.out.println(file.length());

        System.out.println("System.getProperty(\"user.dir\"):\t"+System.getProperty("user.dir"));
        System.out.println("file.getName():\t"+file.getName());
        System.out.println("file.getPath():\t"+file.getPath());
        System.out.println("file.getAbsolutePath:\t"+file.getAbsolutePath());
        System.out.println("file.getParent():\t"+file.getParent());

        File dir = new File("./study/src/com/sk/io/123.txt");
        dir.createNewFile();
    }
}
