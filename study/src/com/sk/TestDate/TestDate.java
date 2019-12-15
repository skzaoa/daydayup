package com.sk.TestDate;

import java.util.Date;

/**
 * @author sk
 * create on  2019/12/15:21:28
 */
public class TestDate {
    public static void main(String[] args) {
        Date d = new Date(1000);
        System.out.println(d);

        System.out.println(d.getTime());
        d.setTime(2000);
        System.out.println(d);
    }
}
