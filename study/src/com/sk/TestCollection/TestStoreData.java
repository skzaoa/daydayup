package com.sk.TestCollection;

import java.util.*;

/**
 * @author sk
 * create on  2019/12/21:20:35
 * 每一行数据使用一个map，整个表格使用一个List
 * ORM思想：对象映射关系
 */
public class TestStoreData {

    public static void main(String[] args) {
        Map<String,Object> row1 = new HashMap<>();
        row1.put("id",1);
        row1.put("name","sk1");
        row1.put("salary",4000);
        row1.put("startDate","2019-10-10");

        Map<String,Object> row2 = new HashMap<>();
        row2.put("id",2);
        row2.put("name","sk1");
        row2.put("salary",4000);
        row2.put("startDate","2019-9-10");

        Map<String,Object> row3 = new HashMap<>();
        row3.put("id",3);
        row3.put("name","sk3");
        row3.put("salary",3000);
        row3.put("startDate","2019-12-10");

        List<Map<String,Object>> table = new ArrayList<>();
        table.add(row1);
        table.add(row2);
        table.add(row3);
        for(Map<String,Object> row:table){

            Set<String> keySet = row.keySet();
            for(String key:keySet){
                System.out.print(key+":"+row.get(key)+"\t");
            }
            System.out.println();
        }
    }
}
