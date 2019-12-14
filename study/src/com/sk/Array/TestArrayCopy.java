package com.sk.Array;

/**
 * @author sk
 * create on  2019/12/14:17:16
 * 数组的copy
 */
public class TestArrayCopy {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        TestArrayCopy t1 = new TestArrayCopy();
        String[] s1 = {"aa","bb","cc","dd","ee"};
        String[] s2 = new String[10];

        //基本复制
        System.arraycopy(s1,2,s2,3,3);
        t1.show(s1,1);
        t1.show(s2,1);

        //新增
        String[] s22 = new String[s2.length+1];
        System.arraycopy(s2,0,s22,0,s2.length);
        //s2 = s22;
        System.arraycopy(s2,4,s2,5,s2.length-4-1);
        System.out.println(String.class.getDeclaredField("value"));
        s2[4] = "cc2";


        System.out.println(s2[4]);
        //System.arraycopy(s21,0,s2,4,1);
        t1.show(s1,2);
        t1.show(s2,2);

        System.arraycopy(s1,2,s2,3,3);
        t1.show(s1,3);
        t1.show(s2,3);

        System.arraycopy(s1,2,s2,3,3);
        t1.show(s1,4);
        t1.show(s2,4);

    }



    public void show(String[] s0,int iLine){
        for (int i = 0; i < s0.length; i++) {
            System.out.println(i+" : "+s0[i]);
        }
        System.out.println("|--"+iLine+"--|");
    }
}
