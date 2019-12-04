package com.sk.PlaneGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author sk
 * create on  2019/12/4:20:47
 */
public class Game extends JFrame {

    Image fjImg = GameUtil.getImage("images/fj.png");
    Image bjImg = GameUtil.getImage("images/bj.jpg");

    //int fjX = 250,fjY = 250;
    Plane plane = new Plane(fjImg,250,250);

    public void paint(Graphics g){
        //自动被调用，g相当于一只画笔
        //Color c = g.getColor();
        //Font f = g.getFont();
        //g.setColor(Color.red);
        //g.drawLine(100,100,100,300);

        //g.drawImage(ball,100,100,null);
        g.drawImage(bjImg,0,0,null);
        //g.drawImage(fjImg,fjX,fjY,null);
        //fjX++;
        plane.drawSelf(g);

        //g.setColor(c);
        //g.setFont(f);
    }

    //反复重画窗口
    class PaintThread extends Thread {
        @Override
        public void run() {
            while(true){
                repaint(); //重画
                System.out.println("重画");
                try {
                    Thread.sleep(40);//1s25次
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 初始化窗口
     */
    public void launchFrame() {
        this.setTitle("游戏人生");
        this.setVisible(true);
        this.setSize(500,500);
        this.setLocation(300,300);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        new PaintThread().start();//启动重画窗口的线程
    }

    public static void main(String[] agrs) {
        Game g = new Game();
        g.launchFrame();
    }
}
