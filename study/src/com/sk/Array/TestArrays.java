package com.sk.Array;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * @author sk
 * create on  2019/12/14:19:06
 */
public class TestArrays {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,3};
        System.out.println(a);
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.binarySearch(a,3));
    }
}
