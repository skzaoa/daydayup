package com.sk.testInterface;

/**
 * @author sk
 * create on  2019/12/8:22:27
 */

interface A {//接口中只有常量、抽象方法
    /*public abstract 写不写都会有*/ void sayA();
    /*public static final 写不写都会有*/String MAX_ = "aa";
    /*public static final 写不写都会有*/int MAX_S = 1;
}

interface B {
    void sayB();
}

interface C extends A,B{//接口支持多继承
    void sayC();
}

public class testInterface implements C{
    @Override
    public void sayA() {
        System.out.println("A...");
    }

    @Override
    public void sayB() {
        System.out.println("B...");
    }

    @Override
    public void sayC() {
        System.out.println("C...");
    }

    public static void main(String[] args) {
        //C c = new C(); //抽象类不能被实例化
        testInterface t1 = new testInterface();
        t1.sayA();
        t1.sayB();
        t1.sayC();
        System.out.println(t1.MAX_S);
    }
}

