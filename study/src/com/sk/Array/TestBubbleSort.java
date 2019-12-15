package com.sk.Array;

import java.util.Arrays;

/**
 * @author sk
 * create on  2019/12/14:19:45
 * 冒泡排序
 */
public class TestBubbleSort {
    public static void main(String[] args) {
        int[] iArrays = {2,5,8,4,1,6,4};
        int iTemp;

        for(int i=0; i<iArrays.length-1; i++) {
            boolean flag = true;
            for (int j = 0; j < iArrays.length-1-i; j++) {
                if (iArrays[j] > iArrays[j + 1]) {
                    iTemp = iArrays[j];
                    iArrays[j] = iArrays[j + 1];
                    iArrays[j + 1] = iTemp;

                    flag = false;
                    System.out.println(Arrays.toString(iArrays));
                }
            }

            if (flag){
                break;
            }
            System.out.println("---------------------");
        }
    }
}
