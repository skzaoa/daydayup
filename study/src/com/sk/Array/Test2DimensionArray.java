package com.sk.Array;

import java.util.Arrays;

/**
 * @author sk
 * create on  2019/12/14:19:16
 */
public class Test2DimensionArray {
    public static void main(String[] args) {
        int[][] a = new int[3][];
        a[0] = new int[]{1,2};
        a[1] = new int[]{3,4,5};
        a[2] = new int[]{6,7};

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(a[0]));
        System.out.println(Arrays.toString(a[1]));
        System.out.println(Arrays.toString(a[2]));
    }


}
