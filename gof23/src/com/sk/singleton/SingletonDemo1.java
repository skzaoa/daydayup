package com.sk.singleton;

/**
 * 饿汉式单例模式
 * @author sk
 * create on  2020/2/1:20:49
 *
 */
public class SingletonDemo1 {
    //类初始化时，立即加载这个对象（没有延时加载优势）。天然的线程安全
    private static SingletonDemo1 instance = new SingletonDemo1();
    private SingletonDemo1() {
    }

    public static SingletonDemo1 getInstance(){
        return instance;
    }
}
