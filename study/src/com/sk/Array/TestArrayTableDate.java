package com.sk.Array;

import java.util.Arrays;

/**
 * @author sk
 * create on  2019/12/14:19:36
 */
public class TestArrayTableDate {
    public static void main(String[] args) {
        Object[] emp1 = {1001,"sk1",18,"2019-01-10"};
        Object[] emp2 = {1002,"sk2",18,"2019-01-11"};
        Object[] emp3 = {1003,"sk3",18,"2019-01-12"};

        Object[][] tableDate = new Object[3][];
        tableDate[0] = emp1;
        tableDate[1] = emp2;
        tableDate[2] = emp3;

        for (Object[] temp:tableDate) {
            System.out.println(Arrays.toString(temp));
        }

    }
}
