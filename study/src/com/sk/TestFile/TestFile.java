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
    }
}
