package com.sk.thread;

/**
 * @author sk
 * create on  2020/1/2:21:41
 */
public class CoSignalLampMethodTest {
    public static void main(String[] args) {
        Tv tv = new Tv();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}

//生产者
class Player extends Thread{
    Tv tv;

    public Player(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {
            if (i%2==0){
                this.tv.play("解放地上"+i);
            }else {
                this.tv.play("降低开了房间"+i);
            }
        }
    }
}
//消费者
class Watcher extends Thread{
    Tv tv;

    public Watcher(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            this.tv.watch();
        }
    }
}

//同一个资源
class Tv{
    String voice;
    boolean flag = true;

    public synchronized void play(String voice){

        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("表演了："+voice);
        this.voice = voice;

        this.notifyAll();
        this.flag = !this.flag;
    }

    public synchronized void watch(){
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("听到了："+voice);
        this.notifyAll();
        this.flag = !this.flag;
    }
}