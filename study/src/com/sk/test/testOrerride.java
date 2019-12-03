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
        System.out.println("v1 end....................");
        Horse v2 = new Horse(); //构造器第一句总是会调用 super()
        System.out.println("v1 end....................");
        Vehicle v3 = new Plane();
        System.out.println("v1 end....................");
        v1.run();//1
        v1.stop();//0
        v2.run();//1
        v2.stop();//0
        v3.run();//1
        v3.stop();//0
        System.out.println("v11....................");
        v1.display();
        System.out.println("v12....................");
        v1.setId(0);
        System.out.println("v13....................");
        v1.display();//
        System.out.println("v20....................");
        v2.run();
        System.out.println("v20....................");
        v2.stop();
        System.out.println("v21....................");
        v2.display();
        System.out.println("v22....................");
        v2.setId(0);
        System.out.println("v23....................");
        v2.display();//
    }
}

class Vehicle{
    int id;
    public Vehicle() {
        System.out.println("Vehicle");
    }

    public void setId(int id) {
        this.id = id;
        display();
    }

    public int getId() {
        return id;
    }

    public void run(){
        setId(1);
        System.out.println(getId()+"跑...");
    }
    public void stop(){
        setId(0);
        System.out.println(getId()+"停止不动");
    }
    public void display() {
        System.out.println(getId());
    }
}

class Horse extends Vehicle{ //extends是继承关键字，java中只有单继承，extends 后面只能有一个父类
    int id;

    public Horse() {
        //super();  无论构造方法中是否写super()，构造方法第一句总是 使用super()来调用父类的构造方法
        System.out.println("Horse");
    }

    @Override
    public void setId(int id) {
        super.setId(1); //使用super可以访问父类中被子类覆盖的对象或对象 此时打印1
        this.id = 0;
        System.out.println(this.id); //子类 打印0
        System.out.println(super.id); //父类 打印1
        display();//此处调用未被父类覆盖的方法，父类方法中访问了id，此处id打印出来是super.id
        System.out.println(this.id); //子类 打印0
    }


    @Override  //继承父类后，若父类方法不适用于子类，则子类可以重写父类方法，加上@Override 可以校验一个方法到底是不是从父类继承的方法
    public void run(){
        super.setId(20);
        super.display();
        setId(1);
        display();
        System.out.println(getId()+"四蹄翻飞，嘚嘚嘚...");
    }
}

class Plane extends Vehicle{
    int id;

    public Plane() {
        System.out.println("Plane");
    }
    @Override
    public void run(){
        setId(1);
        System.out.println(getId()+"天上飞！");
    }
    @Override
    public void stop(){
        setId(0);
        System.out.println(getId()+"天上不能停，柔.....");
    }
}