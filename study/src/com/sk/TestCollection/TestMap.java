package com.sk.TestCollection;

import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sk
 * create on  2019/12/19:21:56
 */
public class TestMap {
    public static void main(String[] args) {
        Map<Integer,String> m1 = new HashMap<>();
        m1.put(1,"sk1");
        m1.put(2,"sk2");
        m1.put(3,"sk3");

        System.out.println(m1.get(1));
        System.out.println(m1.size());
        System.out.println(m1.isEmpty());
        System.out.println(m1.containsKey(1));
        System.out.println(m1.containsValue("sk1"));

        Map<Integer,String> m2 = new HashMap<>();
        m2.put(1,"sk11");
        m2.put(2,"sk22");
        m2.put(3,"sk33");
        m1.putAll(m2);//键值重复，会覆盖原有键值里value
        System.out.println(m1);


        Employee e1 = new Employee(1,"sk1",5000);
        Employee e2 = new Employee(2,"sk2",6000);
        Employee e3 = new Employee(3,"sk2",7000);

        Map<Integer,Employee> m3 = new HashMap<>();
        m3.put(1,e1);
        m3.put(2,e2);
        Employee et1 = m3.get(1);
        System.out.println(et1.getName());
        m3.put(1,e3);
        System.out.println(m3.get(1).getName());
        System.out.println(m3);
    }
}

class Employee{
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id:"+id+", name:"+name+", salary:"+salary;
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
}
