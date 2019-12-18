package com.sk.TestGeneric;

/**
 * @author sk
 * create on  2019/12/16:20:09
 */
public class TestGeneric {
    public static void main(String[] args) {

        MyCollection<String> mc = new MyCollection<>();

        mc.set("123",0);
        String s1 = mc.get(0);
        System.out.println(s1);
    }
}

class MyCollection<E> {
    Object[] objs = new Object[8];

    public E get(int index) {
        return (E)objs[index];
    }

    public void set(E e, int index) {
        objs[index] = e;
    }
}