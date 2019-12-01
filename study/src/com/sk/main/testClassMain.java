
package com.sk.main;
import com.sk.test.*;

/**
 * @author sk
 */

public class testClassMain {
    private int id;
    private String name;
    private double height;

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

    private void testClassDisplay() {
        System.out.println("id=" + getId());
        System.out.println("height=" + getHeight());
        System.out.println("name=" + getName());
    }
    public static void main(String[] args) {
        testClassMain stClassMain = new testClassMain();
        stClassMain.setId(1);
        stClassMain.setHeight(177);
        stClassMain.setName("sk");
        stClassMain.testClassDisplay();

        testClass stCLass = new testClass();
        stCLass.setAge(18);
        stCLass.testClassDisplay();
    }
}
