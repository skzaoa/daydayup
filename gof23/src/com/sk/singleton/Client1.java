package com.sk.singleton;

import java.sql.SQLOutput;
import java.util.concurrent.CountDownLatch;

/**
 * @author sk
 * create on  2020/2/1:21:54
 */
public class Client1 {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        int threadNum = 10;
        final CountDownLatch cdl = new CountDownLatch(threadNum);
        for(int i = 0; i < threadNum; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000000; i++) {
                        Object o = SingletonDemo1.getInstance();
                    }
                    cdl.countDown();
                }
            }).start();
        }
        cdl.await();
        long end = System.currentTimeMillis();
        System.out.println("总耗时："+(end-start));
    }
}
