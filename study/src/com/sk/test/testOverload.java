package com.sk.test;

/**
 * @author sk
 * create on  2019/12/2:20:35
 * 重载的方法，是完全不同的方法，只是名称相同
 *      1. 不同含义：形参类型、形参个数、形参顺序
 *      2. 只有返回值不同不构成构造方法
 *      3. 只有形参名称不同不构成构造方法
 * 使用this调用构造方法，并且必须位于第一行
 * 使用this 区分局部变量、成员变量
 * this 不能写在static方法中
 */
class Point{
    private double x, y, z;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Point(double x, double y, double z) { //重载：构造方法也是方法，也可以重载
        this(x,y); //使用this调用构造方法，并且必须位于第一行
        this.z = z;
    }
    private double getDistance1(Point p) {
        return Math.sqrt((x-p.x)*(x-p.x) + (y-p.y)*(y-p.y));
    }
    private double getDistance2(Point p) {
        return Math.sqrt((x-p.x)*(x-p.x) + (y-p.y)*(y-p.y) + (z-p.z)*(z-p.z));
    }
    public void  display(Point p) {
        if (p.z != 0 || this.z != 0) //使用this 区分局部变量、成员变量
            System.out.println("三点"+this.getDistance2(p));
        else
            System.out.println("两点"+this.getDistance1(p));
    }
}

public class testOverload {
    public void pfTestOverload() {
        Point p1 = new Point(3,4);
        Point p2 = new Point(3,4,5);

        Point o = new Point(0,0,0);
        p1.display(o);
        p2.display(o);
    }

}


