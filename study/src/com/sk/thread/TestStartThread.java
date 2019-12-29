package com.sk.thread;

/**
 * @author sk
 * create on  2019/12/28:19:51
 * 创建线程的方法：
 * 1、继承Thread，重写run():void
 * 2、start():void
 */
public class TestStartThread extends Thread{

    /**
     * 线程切入口
     */
    @Override
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            System.out.println("听歌");
        }
    }

    public static void main(String[] args) {

        TestStartThread tst = new TestStartThread();
        tst.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("学习");
        }
    }
}
