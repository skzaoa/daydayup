package com.sk.net;

import java.net.InetSocketAddress;

/**
 * @author sk
 * create on  2020/1/3:19:42
 */
public class InetSocketAddressTest {
    public static void main(String[] args) {
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8080);
        InetSocketAddress socketAddress2 = new InetSocketAddress("localhost", 9000);
        System.out.println(socketAddress.getHostName());
        System.out.println(socketAddress2.getAddress());
    }
}
