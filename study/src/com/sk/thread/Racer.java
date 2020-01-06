package com.sk.thread;

/**
 * @author sk
 * create on  2019/12/30:20:30
 */
public class Racer implements Runnable{

    private static String winner;
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (Thread.currentThread().getName().equals("rabbit")&&i%10==0){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"-->"+i);
            boolean flag = gameOver(i);
            if(flag){
                break;
            }
        }
    }
    private boolean gameOver(int steps){
        if (winner != null){
            return true;
        }else {
            if (100 == steps){
                winner = Thread.currentThread().getName();
                System.out.println("winner-->"+winner);
            }
            return false;
        }

    }

    public static void main(String[] args) {
        Racer r = new Racer();
        new Thread(r,"rabbit").start();
        new Thread(r,"tortoise").start();
    }
}
