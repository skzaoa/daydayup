package com.sk.net;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author sk
 * create on  2020/1/3:21:20
 * 统一资源定位器，互联网三大基石之一（http,html），区分资源
 * 1.协议
 * 2.域名、计算机名
 * 3.端口：默认80
 * 4.请求资源
 * http://www.baidu.com:80/index.html
 */
public class UrlTest {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://www.baidu.com:80/index.html?uname=11#2");
        System.out.println("协议："+url.getProtocol());
        System.out.println("域名："+url.getHost());
        System.out.println("请求资源："+url.getFile());
        System.out.println("请求资源："+url.getPath());

        System.out.println("参数："+url.getQuery());
        System.out.println("锚点："+url.getRef());
    }
}
