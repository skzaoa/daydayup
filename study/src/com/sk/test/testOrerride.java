package com.sk.test;

public class testOrerride {

    public void pfTestOverride() {
        Vehicle v1 = new Vehicle();
        Vehicle v2 = new Horse();
        Vehicle v3 = new Plane();
        v1.run();
        v2.run();
        v3.run();
        v1.stop();
        v2.stop();
        v3.stop();
    }
}

class Vehicle{
    public void run(){
        System.out.println("跑...");
    }
    public void stop(){
        System.out.println("停止不动");
    }
}

class Horse extends Vehicle{
    @Override
    public void run(){
        System.out.println("四蹄翻飞，嘚嘚嘚...");
    }
}

class Plane extends Vehicle{
    @Override
    public void run(){
        System.out.println("天上飞！");
    }
    @Override
    public void stop(){
        System.out.println("天上不能停，柔.....");
    }
}