package com.sk.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author sk
 * create on  2020/1/3:21:32
 */
public class SpiderTestr {
    public static void urltest1() throws IOException {
        URL url = new URL("https://www.jd.com");
        InputStream is = url.openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
        String msg = null;
        while (null!=(msg=br.readLine())){
            System.out.println(msg);
        }
        br.close();
    }

    public static void urltest2() throws IOException {
        URL url = new URL("https://www.dianping.com");
        //InputStream is = url.openStream();
        HttpURLConnection huc = (HttpURLConnection)url.openConnection();
        huc.setRequestMethod("GET");
        huc.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3314.0 Safari/537.36 SE 2.X MetaSr 1.0");
        BufferedReader br = new BufferedReader(new InputStreamReader(huc.getInputStream(),"UTF-8"));
        String msg = null;
        while (null!=(msg=br.readLine())){
            System.out.println(msg);
        }
        br.close();
    }
    public static void main(String[] args) throws IOException {
        //urltest1();
        urltest2();
    }

}
