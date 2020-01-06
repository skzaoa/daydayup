package com.sk.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author sk
 * create on  2020/1/3:19:22
 * ip定位一个节点：计算机，路由，通信设备
 */
public class IpTest {
    public static void main(String[] args) throws UnknownHostException {

        InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr.getHostAddress());//返回：192.168.0.100
        System.out.println(addr.getHostName());//输出计算机名

        //根据域名过去InetAddress对象
        addr = InetAddress.getByName("www.163.com");
        System.out.println(addr.getHostAddress());//返回：192.168.0.100
        System.out.println(addr.getHostName());//输出计算机名

        //根据ip过去InetAddress对象
        addr = InetAddress.getByName("111.225.213.21");
        System.out.println(addr.getHostAddress());//返回：192.168.0.100
        System.out.println(addr.getHostName());//输出计算机名
    }
}
