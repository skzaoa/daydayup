package com.sk.TestCollection;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author sk
 * create on  2019/12/21:20:14
 */
public class TestCollections {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("sk"+i);
        }
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        System.out.println(Collections.binarySearch(list,"sk1"));
    }
}
