package com.sk.test;

/**
 * @author sk
 * create on  2019/12/2:20:35
 * extends是继承关键字，java中只有单继承，extends 后面只能有一个父类
 * 继承父类后，若父类方法不适用于子类，则子类可以重写父类方法，加上@Override 可以校验一个方法到底是不是从父类继承的方法
 */

public class testOrerride {

    public void pfTestOverride() {
        Vehicle v1 = new Vehicle(); //使用对象需要先new
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

class Horse extends Vehicle{ //extends是继承关键字，java中只有单继承，extends 后面只能有一个父类
    @Override  //继承父类后，若父类方法不适用于子类，则子类可以重写父类方法，加上@Override 可以校验一个方法到底是不是从父类继承的方法
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