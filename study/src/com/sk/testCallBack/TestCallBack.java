package com.sk.testCallBack;

/**
 * @author sk
 * create on  2019/12/8:22:44
 * 回调
 */
public class TestCallBack {
    public static void testCallBack(Back b) {
        System.out.println("aa");
        //回调
        b.back();
    }
    public static void main(String[] args) {
        TestCallBack t1 = new TestCallBack();
        t1.testCallBack(new MyBack1());
    }
}

class MyBack1 extends Back {
    @Override
    public void back() {
        System.out.println("MyBack1.back()");
    }
}
