package com.sk.test;

/**
 * @author sk
 * create on  2019/12/16:18:41
 */
public class TestEnum {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);

        Season a = Season.AUTUMN;

        switch (a){
            case SPRING:
                System.out.println("SPRING");
                break;
            case SUMMER:
                System.out.println("SUMMER");
                break;
            case AUTUMN:
                System.out.println("AUTUMN");
                break;
            case WINTER:
                System.out.println("WINTER");
                break;
        }
    }
}

enum Season{
    SPRING,SUMMER,AUTUMN,WINTER
}

enum Week{
    星期一,星期二,星期三,星期四,星期五,星期六,星期日
}