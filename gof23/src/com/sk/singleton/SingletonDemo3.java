package com.sk.singleton;

/**
 * 双重检测锁单例模式
 * @author sk
 * create on  2020/2/1:20:56
 */
public class SingletonDemo3 {

    //类初始化时，不立即加载这个对象（有延时加载优势）
    private static SingletonDemo3 instance = null;
    private SingletonDemo3() {
    }

    public static SingletonDemo3 getInstance(){
        if (instance == null){
            SingletonDemo3 sc;
            synchronized (SingletonDemo3.class){
                sc = instance;
                if (sc == null){
                    synchronized (SingletonDemo3.class){
                        sc = new SingletonDemo3();
                    }
                    instance = sc;
                }
            }
        }
        return instance;
    }
}
