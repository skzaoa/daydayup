package com.sk.thread;

/**
 * @author sk
 * create on  2019/12/30:20:51
 */
public class ThreadStatusTerminateTest implements Runnable{
    //标记
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag){
            System.out.println(Thread.currentThread().getName()+i++);
        }

    }

    public void terminate(){
        this.flag = false;
    }

    public static void main(String[] args) {

        ThreadStatusTerminateTest tstt = new ThreadStatusTerminateTest();
        new Thread(tstt,"sk1").start();
        for (int i = 0; i <= 89; i++) {
            System.out.println("main-->"+i);
            if (88 == i){
                tstt.terminate();
                System.out.println("终止。。。");
            }
        }
    }
}
