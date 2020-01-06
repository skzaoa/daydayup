package com.sk.thread;

/**
 * @author sk
 * create on  2020/1/1:9:53
 */
public class ThreadLambdaTest {
    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                System.out.println("听歌"+i);
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                System.out.println("学习"+i);
            }
        }).start();
    }
}
