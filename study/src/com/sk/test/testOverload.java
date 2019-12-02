package com.sk.test;

/**
 * @author sk
 * create on  2019/12/2:20:35
 */
class Point{
    private double x, y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    private double getDistance(Point p) {
        return Math.sqrt((x-p.x)*(x-p.x) + (y-p.y)*(y-p.y));
    }
    public void  display(Point p) {
        System.out.println(this.getDistance(p));
    }
}

public class testOverload {
    public void pfTestOverload() {
        Point p = new Point(3,4);
        Point o = new Point(0,0);
        p.display(o);
    }

}


