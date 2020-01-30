package com.sk.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author sk
 * create on  2020/1/16:21:33
 */
public class JDBCTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1、加载驱动类
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //2、获取数据库连接对象(连接指定数据库)
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","skuser","skuser");
        //设置事务手动提交
        conn.setAutoCommit(false);
        //3、获取sql命令对象(编译和发送sql命令给数据库)
        Statement stmt = conn.createStatement();
        //4、创建sql命令
        String sql = "Insert into sktest (ID,NAME) values (2,'sk2') ";
        //5、指定sql
        try {
            int ret = stmt.executeUpdate(sql);
            System.out.println("执行结果 : " + ret);
            conn.commit();
        } catch (Exception e){
            conn.rollback();
        }
        //6、关闭资源
        stmt.close();
        conn.close();
    }
}
