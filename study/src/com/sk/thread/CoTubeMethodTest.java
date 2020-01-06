package com.sk.thread;

/**
 * @author sk
 * create on  2020/1/2:21:10
 */
public class CoTubeMethodTest {


    public static void main(String[] args) {

        SynContainer container = new SynContainer();
        new Productor(container).start();
        new Consumer(container).start();

    }
}


//生产者
class Productor extends Thread{
    SynContainer container;
    public Productor(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run(){
        //生产
        for (int i = 0; i < 100; i++) {
            System.out.println("生产-->"+i+"个馒头");
            container.push(new Steamedbun(i));
        }
    }
}
//消费者
class Consumer extends Thread{
    SynContainer container;
    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
       //消费
        for (int i = 0; i < 100; i++) {
            System.out.println("消费-->"+container.pop().id+"个馒头");
        }
    }
}
//缓冲区
class SynContainer{
    Steamedbun[] buns = new Steamedbun[10];
    int count = 0;
    //生产
    public synchronized void push(Steamedbun bun){
        if(count == buns.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buns[count++] = bun;
        //count++;

        this.notifyAll();
    }
    //消费
    public synchronized Steamedbun pop(){
        if(count==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Steamedbun bun =  buns[count];
        this.notifyAll();
        return bun;
    }

}
//馒头
class Steamedbun{
    int id;

    public Steamedbun(int id) {
        this.id = id;
    }
}