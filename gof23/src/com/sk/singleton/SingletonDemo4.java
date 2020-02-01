package com.sk.singleton;

/**
 * 静态内部类单例模式
 * @author sk
 * create on  2020/2/1:20:56
 */
public class SingletonDemo4 {

    //类初始化时，不立即加载这个静态内部类（有延时加载优势）
    private static class SingletonClassInstance{
        private static final SingletonDemo4 instance = new SingletonDemo4();
    }
    private SingletonDemo4() {
    }

    public static SingletonDemo4 getInstance(){
        return SingletonClassInstance.instance;
    }
}
