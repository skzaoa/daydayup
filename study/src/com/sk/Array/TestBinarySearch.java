package com.sk.Array;

import java.util.Arrays;

/**
 * @author sk
 * create on  2019/12/14:20:05
 * 折半查找 二分查找 binary search
 */
public class TestBinarySearch {
    public static void main(String[] args) {
        int[] iArrays = {2,5,8,4,1,6,4};
        Arrays.sort(iArrays);
        int low = 0;
        int high = iArrays.length-1;
        int value = 9;
        int mid = 0;
        boolean flag = false;
        while (low<=high){
            mid = (low+high)/2;

            if (iArrays[mid] == value){
                System.out.println("zhodaole");
                flag = true;
                break;
            }
            if (iArrays[mid] < value){
                low = mid+1;
            }
            if (iArrays[mid] > value){
                high = mid-1;
            }
        }
        if (!flag) {
            System.out.println("meizhodao");
        }
        System.out.println(Arrays.toString(iArrays));
        System.out.println(mid);
    }
}
