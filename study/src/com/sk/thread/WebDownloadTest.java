package com.sk.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author sk
 * create on  2019/12/28:20:03
 */
public class WebDownloadTest {

    public void download(String url, String name){
        try {
            System.out.println(name+"， 线程名："+Thread.currentThread().getName());
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
