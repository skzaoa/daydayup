package com.sk.Array;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author sk
 * create on  2019/12/11:19:28
 */
public class TestArrayList {
    public static void main(String[] args) {
        System.out.println("start test ArrayList !!!!");
        int[] a1 = new int[3];
        Scanner s1 = new Scanner(System.in);  //键盘输入
        for (int i = 0; i < a1.length; i++) {
            //System.out.println("共"+a1.length+"个int，请输入第"+(i+1)+"个int：");
            //a1[i] = s1.nextInt();
        }
        for (int i = 0; i < a1.length; i++) {
            System.out.println(a1[i]);
        }

        ArrayList<Integer> list1 = new ArrayList<>();  //ArrayList<E> 泛型
        /*
        * ArrayList对象不能存储基本类型，只能存储引用类型数据 e.g. <int>对应Interger
        * 基本类型  基本类型包装类
        * byte      Byte
        * short     Short
        * int       Integer
        * long      Long
        * flout     Flout
        * double    Double
        * char      Character
        * boolean   Boolean
        * */

        /*
        * java中自动装箱、自动拆箱
        * 自动装箱：基本类型->基本类型包装类
        * 自动拆箱：基本类型包装类->基本类型
        *
        * */
        Random r1 = new Random();  //生成随机数
        for (int i = 0; i <5 ; i++) {
            list1.add(r1.nextInt(5)+1);
        }

        System.out.println(list1);

        ArrayList<Student> st1= new ArrayList<>();
        st1.add(new Student("sk",18));
        st1.add(new Student("sk1",18));
        st1.add(new Student("sk2",18));// 添加到末尾
        System.out.println(st1);
        System.out.println(st1.get(0));//获取指定位置元素
        System.out.println(st1.size());// 获取元素数
        st1.remove(1);//移除
        System.out.println(st1);

    }
}

class Student {
    String name;
    int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

}
