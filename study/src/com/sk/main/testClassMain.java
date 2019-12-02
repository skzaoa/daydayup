
package com.sk.main;
import com.sk.test.*;

/**
 * @author sk
 */

public class testClassMain {
    private int id;
    private String name;
    private double height;
    private static String Sex; //static修饰的成员变量和方法从属于类，普通变量和方法从属于对象，不需要实例化

    private int getId(){
        return id;
    }
    private void setId(int id){
        this.id = id;
    }
    private String getName(){
        return name;
    }
    private void setName(String name){
        this.name = name;
    }
    private double getHeight(){
        return height;
    }
    private void setHeight(double height){
        this.height = height;
    }
    private static String getSex(){
        return Sex;  //static方法中只能访问static变量
    }
    private void setSex(String Sex){
        this.Sex = Sex;
    }

    private void testClassDisplay() {
        System.out.println("id=" + getId());
        System.out.println("height=" + getHeight());
        System.out.println("name=" + getName());
        System.out.println("Sex=" + getSex());
    }
    public static void main(String[] args) {
        testClassMain st1 = new testClassMain();
        st1.setId(1);
        st1.setHeight(177);
        st1.setName("sk");
        st1.setSex("男");
        st1.testClassDisplay();

        System.out.println("直接使用类名.类属性/类方法 testClassMain.Sex=" + testClassMain.Sex);

        testClassMain st2 = new testClassMain();
        st2.testClassDisplay();

        testClass stCLass = new testClass();
        stCLass.setAge(18);
        stCLass.testClassDisplay();
    }
}
