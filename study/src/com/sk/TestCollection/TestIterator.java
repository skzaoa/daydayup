package com.sk.TestCollection;

import java.util.*;

/**
 * @author sk
 * create on  2019/12/21:19:43
 *
 * 迭代器
 */
public class TestIterator {

    public static void testIteratorList(){

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add("sk"+i);
        }
        for(Iterator<String> iter = list.iterator(); iter.hasNext();){
            String temp = iter.next();
            System.out.println(temp);
        }
        System.out.println("11111111111");
    }

    public static void testIteratorSet(){
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            set.add("sk"+i);
        }
        for(Iterator<String> iter = set.iterator(); iter.hasNext();){
            String temp = iter.next();
            System.out.println(temp);
        }
        System.out.println("11111111111");
    }

    public static void testIteratorMap(){

        Map<Integer,String> map = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            map.put(i,"sk"+i);
        }

        Set<Map.Entry<Integer,String>> ss= map.entrySet();
        for(Iterator<Map.Entry<Integer,String>> iter = ss.iterator(); iter.hasNext();){
            Map.Entry<Integer,String> temp = iter.next();
            System.out.println(temp);
        }
        System.out.println("11111111111");
        Set<Integer> keySet = map.keySet();
        for(Iterator<Integer> iter = keySet.iterator();iter.hasNext();){
            Integer key = iter.next();
            System.out.println(key+"="+map.get(key));
        }
        System.out.println("11111111111");
    }
    public static void main(String[] args) {
        //TestIterator it = new TestIterator();
        testIteratorList();
        testIteratorSet();
        testIteratorMap();
    }
}
