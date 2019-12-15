package com.sk.TestDate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author sk
 * create on  2019/12/15:21:53
 */
public class TestCalendar {
    public static void main(String[] args) {
        Calendar cal = new GregorianCalendar(2019,12,15,10,55,50);
        //获取日期
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DATE);
        System.out.println(cal);
        System.out.println(year+"/"+month+"/"+day);
        //设置日期
        cal.set(Calendar.YEAR,2099);
        System.out.println(cal.get(Calendar.YEAR));

        //默认当前时间
        Calendar cal1 = new GregorianCalendar();
        System.out.println(cal1.get(Calendar.MONTH));

        //日期计算
        cal1.add(Calendar.YEAR,1);
        System.out.println(cal1.get(Calendar.YEAR));

        //日期对象和时间对象转换
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d4 = cal1.getTime();
        System.out.println(d4.toString());
        System.out.println(df.format(d4));
        cal.setTime(new Date());
        System.out.println(cal.get(Calendar.YEAR)+":"+cal.get(Calendar.MONTH)+":"+cal.get(Calendar.DAY_OF_MONTH));


    }
}
