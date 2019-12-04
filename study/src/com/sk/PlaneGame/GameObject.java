package com.sk.PlaneGame;

import java.awt.*;

/**
 * @author sk
 * create on  2019/12/4:22:38
 * 物品父类
 */
public class GameObject {
    Image img;
    double x,y;
    int speed;
    int width,height;

    public void  drawSelf(Graphics g) {
        g.drawImage(img,(int)x,(int)y,null);
    }

    public GameObject(Image img, double x, double y, int speed, int width, int height) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }

    public GameObject(Image img, double x, double y) {
        this.img = img;
        this.x = x;
        this.y = y;
    }

    public GameObject() {
    }

    /**
     *
     * 帮助返回矩形，便于后续碰撞检测
     * @return
     */
    public Rectangle getRect() {
        return new Rectangle((int)x,(int)y,width,height);
    }
}
