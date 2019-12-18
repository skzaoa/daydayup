package com.sk.TestException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author sk
 * create on  2019/12/16:19:18
 */
public class TestTryCatchFinally {
    public static void main(String[] args) {
        readMyFile();
    }

    public static void readMyFile(){
        FileReader reader = null;
        try {
            reader = new FileReader("d:/b.txt");
            char c1 = (char)reader.read();
            System.out.println(c1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) { //子类异常在父类异常前面
            e.printStackTrace();
        }finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
