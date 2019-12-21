package com.sk.TestCollection;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author sk
 * create on  2019/12/21:19:36
 */
public class TestTreeSet {
    public static void main(String[] args) {
        Set<Emp> set = new TreeSet<>();

        set.add(new Emp(2,"sk2",4000));
        set.add(new Emp(1,"sk2",5000));
        set.add(new Emp(3,"sk2",4000));
        System.out.println(set.toString());
    }
}
