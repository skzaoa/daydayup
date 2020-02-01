package com.sk.singleton;

/**
 * 懒汉式单例模式
 * @author sk
 * create on  2020/2/1:20:56
 */
public class SingletonDemo2 {

    //类初始化时，不立即加载这个对象（有延时加载优势）
    private static SingletonDemo2 instance;
    private SingletonDemo2() {
    }

    public static synchronized SingletonDemo2 getInstance(){
        if (instance == null){
            instance = new SingletonDemo2();
        }
        return instance;
    }
}
