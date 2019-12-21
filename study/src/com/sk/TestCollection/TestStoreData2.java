package com.sk.TestCollection;

import java.util.*;

/**
 * @author sk
 * create on  2019/12/21:20:54
 *
 * 体会ORM思想
 * 每一行数据使用javabean对象，多行放到map或list中
 */
public class TestStoreData2 {
    public static void main(String[] args) {
        User user1 = new User(1,"sk1",2000,"2019-09-09");
        User user2 = new User(2,"sk2",7000,"2019-05-09");
        User user3 = new User(3,"sk3",5000,"2019-11-09");

        List<User> list= new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);

        for(User user:list){
            System.out.println(user);
        }

        System.out.println("--------------------------------");
        Map<Integer,User> map = new HashMap<>();
        map.put(1,user1);
        map.put(2,user2);
        map.put(3,user3);

        Set<Integer> key= map.keySet();
        for(Integer i:key){
            System.out.println(map.get(i));
        }
    }
}

class User{
    private int id;
    private String name;
    private double salary;
    private String hiredate;

    User(int id, String name, double salary, String hiredate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.hiredate = hiredate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    @Override
    public String toString() {
        return "id:"+id+", name:"+name+", salary:"+salary+", hiredate:"+hiredate;
    }
}