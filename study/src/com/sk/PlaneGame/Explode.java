package com.sk.PlaneGame;

import java.awt.*;

/**
 * @author sk
 * create on  2019/12/7:21:17
 */
public class Explode {
    double x,y;
    static Image[] imgs = new Image[16];
    static {
        for(int i=0;i<16;i++){
            imgs[i] = GameUtil.getImage("images/explode/e"+(i+1)+".gif");
            imgs[i].getWidth(null);
        }
    }

    int count;

    public void draw(Graphics g){
        if(count<=15){
            g.drawImage(imgs[count], (int)x, (int)y, null);
            //count++;
        }
    }

    public Explode(double x,double y){
        this.x = x;
        this.y = y;
        this.count = 0;
    }
}
