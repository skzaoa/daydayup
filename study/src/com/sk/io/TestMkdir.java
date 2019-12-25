package com.sk.io;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author sk
 * create on  2019/12/23:20:03
 */
public class TestMkdir {
    public static void main(String[] args) throws IOException {
        File dir = new File("D:/src/tmp/1.txt");
        dir.createNewFile();
        boolean flag = dir.mkdirs();
        System.out.println(flag);
        dir = new File("D:/src/tmp");

        //下级名称
        String[]subNames = dir.list();
        System.out.println(Arrays.toString(subNames));
        for(String s:subNames){
            System.out.println(s);
        }

        //下级对象
        File[] f1 = dir.listFiles();
        for(File s:f1){
            System.out.println(s.getAbsolutePath());
        }

        System.out.println("---------------");
        printFiles(dir, 0);
        System.out.println("-----");
        count(dir);
        System.out.println(len);

    }

    private static void printFiles(File f1,int deep){

        System.out.print("|");
        for (int i = 0; i < deep; i++) {
            System.out.print("--");
        }
        System.out.print("|");
        System.out.println(f1.getName());

        if(f1 == null ||!f1.exists()){
            return ;
        }else if (f1.isDirectory()){
            for(File s:f1.listFiles()){
                printFiles(s,deep+1);
            }
        }



    }
    private static long len = 0;
    private static void count(File f1){

        System.out.println(f1.getName());

        if(f1 != null &&f1.exists()){
            if(f1.isFile()){
                len+=f1.length();
            }else{
                for(File s:f1.listFiles()){
                    count(s);
                }
            }
        }

    }
}
