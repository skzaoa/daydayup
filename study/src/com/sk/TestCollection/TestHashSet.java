package com.sk.TestCollection;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sk
 * create on  2019/12/21:19:14
 */
public class TestHashSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("sk1");
        set.add("sk1");
        set.add("sk2");
        System.out.println(set);
    }
}
