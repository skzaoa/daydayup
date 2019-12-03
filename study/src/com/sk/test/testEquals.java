package com.sk.test;

import java.util.Objects;

/**
 * @author sk
 * create on  2019/12/3:20:19
 * equals 方法
 */
public class testEquals {
    int id;
    String name;

    public testEquals() {
    }

    public testEquals(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        testEquals that = (testEquals) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void pfTestEquals() {
        testEquals t1 = new testEquals(1,"sk1");
        testEquals t2 = new testEquals(1,"sk2");
        System.out.println(t1 == t2);
        System.out.println(t1.equals(t2));

        String s1 = new String("sk1");
        String s2 = new String("sk1");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}
