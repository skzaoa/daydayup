package com.sk1.server;

/**
 * @author sk
 * create on  2020/1/5:20:49
 */
public class RefleectTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        //三种方式
        //1、对象.getClass()
        SS0001 ss = new SS0001();
        Class clz = ss.getClass();
        //2、类.class
        clz = SS0001.class;
        //3、Class.forName()
        clz = Class.forName("com.sk1.server.SS0001");

        //创建对象
        SS0001 ss1 = (SS0001)clz.newInstance();
        //JDK9以后推荐使用
        //SS0001 ss1 = (SS0001)clz.getConstructor().newInstance();

        ss1.display();

    }
}


class SS0001{
    public SS0001() {
    }

    public void display(){
        System.out.println("haha");
    }
}