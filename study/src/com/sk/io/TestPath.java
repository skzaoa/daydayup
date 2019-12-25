package com.sk.io;

import java.io.File;

/**
 * @author sk
 * create on  2019/12/21:21:53
 */
public class TestPath {
    public static void main(String[] args) {
        String path = "D:\\src\\daydayup\\study\\src\\images";

        //1./
        path ="D:/src/daydayup/study/src/images";
        System.out.println(path);
        //2、常量拼接

        path = "D:"+ File.separator
                +"src"+ File.separator
                +"daydayup"+ File.separator
                +"study"+ File.separator
                +"src"+ File.separator
                +"images"+ File.separator;
        System.out.println(path);
    }
}
