package com.sk.TestException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author sk
 * create on  2019/12/16:19:28
 */
public class TestThrows {
    public static void main(String[] args) throws IOException {

        readMyFile1();
    }

    public static void readMyFile1() throws IOException {
        FileReader reader = null;

        reader = new FileReader("d:/b.txt");
        char c1 = (char)reader.read();
        System.out.println(c1);

        reader.close();
    }
}
