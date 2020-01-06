package com.sk.thread;

/**
 * @author sk
 * create on  2019/12/30:20:18
 */
public class ThreadRunnableTest implements Runnable{

    private int iCount  ;

    public ThreadRunnableTest(int iCount) {
        this.iCount = iCount;
    }

    @Override
    public void run() {
        while (true){
            if (iCount <0){
                break;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->"+iCount--);
        }
    }

    public static void main(String[] args) {
        ThreadRunnableTest trt1 = new ThreadRunnableTest(30);
        //System.out.println(Thread.currentThread().getName());
        new Thread(trt1,"sk1").start();
        new Thread(trt1,"sk2").start();
        new Thread(trt1,"sk3").start();
    }
}
