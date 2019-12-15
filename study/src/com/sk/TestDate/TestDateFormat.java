package com.sk.TestDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author sk
 * create on  2019/12/15:21:34
 */
public class TestDateFormat {
    public static void main(String[] args) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = new Date();
        System.out.println(df.format(d1));

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入时间（e.g.:2019-1-1）");
        String str = sc.nextLine();
        Date d2 = df1.parse(str);// 固定格式string日期 转换为 date日期
        System.out.println(df.format(d2));//date日期 转换为 固定格式string日期
    }
}
