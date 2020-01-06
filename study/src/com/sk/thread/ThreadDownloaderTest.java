package com.sk.thread;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author sk
 * create on  2019/12/30:19:14
 */
public class ThreadDownloaderTest extends Thread{
    private String url; //远程路径
    private String name; //存储路径

    public ThreadDownloaderTest(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloadTest wd = new WebDownloadTest();
        wd.download(url,name);
    }

    public static void main(String[] args) {

        String url1 = "http://pic1.win4000.com/wallpaper/9/598984337b733.jpg";
        String name1 = "../tmp/1.jpg";
        String url2 = "http://pic1.win4000.com/wallpaper/9/5989843594c87.jpg";
        String name2 = "../tmp/2.jpg";
        String url3 = "http://pic1.win4000.com/wallpaper/9/5989842ac75c1.jpg";
        String name3 = "../tmp/3.jpg";

        ThreadDownloaderTest tdt1 = new ThreadDownloaderTest(url1,name1);
        ThreadDownloaderTest tdt2 = new ThreadDownloaderTest(url2,name2);
        ThreadDownloaderTest tdt3 = new ThreadDownloaderTest(url3,name3);
        tdt1.start();
        tdt2.start();
        tdt3.start();
    }
}
