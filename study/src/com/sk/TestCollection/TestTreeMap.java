package com.sk.TestCollection;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author sk
 * create on  2019/12/21:18:44
 */
public class TestTreeMap {
    public static void main(String[] args) {
        Map<Integer,String> treeMap = new TreeMap<>();
        treeMap.put(2,"sk2");
        treeMap.put(1,"sk1");
        treeMap.put(3,"sk3");
        for(Integer key:treeMap.keySet()){
            System.out.println(key+"   "+treeMap.get(key));
        }
        Map<Emp,String> treeMap1 = new TreeMap<>();
        treeMap1.put(new Emp(3,"sk3",4000),"sk3aaaaaaa");
        treeMap1.put(new Emp(2,"sk2",5000),"sk2bbbbbbb");
        treeMap1.put(new Emp(1,"sk1",5000),"sk1ccccccc");

        for(Emp key:treeMap1.keySet()){
            System.out.println(key+"---"+treeMap1.get(key));
        }
    }
}

class Emp implements Comparable<Emp>{
    private int id;
    private String name;
    private double salary;

    Emp(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Emp o) {
        if(this.salary>o.salary){
            return 1;
        }else if (this.salary<o.salary){
            return -1;
        }else {
            return Integer.compare(this.id, o.id);
        }
    }

    @Override
    public String toString() {
        return "id:"+id+", name:"+name+", salary:"+salary;
    }
}
