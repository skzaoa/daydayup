package com.sk.TestFile;

import java.io.File;

/**
 * @author sk
 * create on  2019/12/15:22:54
 */
public class TestFile {
    public static void main(String[] args) {
        File f = new File("d:\\a.txt");
        System.out.println(f);
        f.renameTo(new File("d:\\b.txt"));
        TestFile t1 = new TestFile();
        File f1 = new File("D:\\src\\daydayup\\out\\production\\study\\images");
        t1.printFile(f1,0);
    }

    static void printFile(File file, int level) {
        for (int i = 0; i <level ; i++) {
            System.out.print("-");
        }
        System.out.println(file.getName());
        if (file.isDirectory()){
            File[] files = file.listFiles();
            for(File temp:files){
                printFile(temp,level+1);
            }
        }
    }
}
