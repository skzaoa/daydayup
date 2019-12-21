package com.sk.TestCollection;

import java.security.PublicKey;
import java.util.HashMap;

/**
 * @author sk
 * create on  2019/12/21:19:20
 */
public class TestMyHashSet {
    private HashMap map;
    private static final Object PRESENT =new Object();

    public TestMyHashSet(){
        map = new HashMap();
    }
    private void add(Object o){
        map.put(o,PRESENT);
    }
    public int size(){
        return map.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Object key:map.keySet()) {
            sb.append(key).append(",");
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public static void main(String[] args) {
        TestMyHashSet myset = new TestMyHashSet();
        myset.add("sk1");
        myset.add("sk1");
        myset.add("sk2");
        System.out.println(myset.toString());

    }
}
