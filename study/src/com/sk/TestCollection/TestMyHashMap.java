package com.sk.TestCollection;

/**
 * @author sk
 * create on  2019/12/21:12:51
 */
public class TestMyHashMap<E,V> {

    MapNode<E,V>[] table;
    int size;

    public TestMyHashMap() {
        //长度一般定义为2^n
        table = new MapNode[10];
    }

    public void put(){}

    public static void main(String[] args) {
        TestMyHashMap mymap = new TestMyHashMap();

    }
}
