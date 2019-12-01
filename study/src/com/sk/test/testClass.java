package com.sk.test;

/**
 * @author sk
 */

public class testClass {
    private int age;
    private int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void testClassDisplay(){
        System.out.println("age=" + getAge());
    }
}
