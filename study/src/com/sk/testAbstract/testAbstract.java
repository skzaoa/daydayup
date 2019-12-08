package com.sk.testAbstract;

/**
 * @author sk
 * create on  2019/12/8:22:06
 *
 * 抽象方法：使用abstract修饰，没有方法体，只有声明。定义的是一种规范，就是告诉子类必须要实现抽象方法。
 * 抽象类：包含抽象方法的类就是抽象类，通过abstract修饰，通过抽象类，可以做到严格限制子类的设计，使子类更加通用。
 */
public class testAbstract {
    public static void main(String[] args) {
        //Animal a0 = new Animal(); //抽象类不能被实例化
        Animal a1 = new Dog();
        a1.say();
        a1.a = 12;
        System.out.println("a1.a="+a1.a);
    }
}

abstract class Animal {//类里面有抽象方法，只能定义成抽象类
    int a;//抽象类可以包含属性、方法、构造方法。但是构造方法不能用来new实例，只能用来被子类调用
    public abstract void say(); //抽象方法
}

class Dog extends Animal {//抽象类只能被子类继承

    @Override
    public void say() {//子类必须实现父类抽象方法，否则编译报错
        System.out.println("汪汪汪！！！");
    }
}
