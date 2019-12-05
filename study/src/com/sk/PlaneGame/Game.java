package com.sk.PlaneGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author sk
 * create on  2019/12/4:20:47
 */
public class Game extends Frame {

    Image fjImg = GameUtil.getImage("images/fj.png");
    Image bjImg = GameUtil.getImage("images/bj.jpg");

    //int fjX = 250,fjY = 250;
    Plane plane = new Plane(fjImg,250,250);
    Shell[] shells = new Shell[50];

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

        //shell.draw(g);
        for(int i=0;i<shells.length;i++) {
            shells[i].draw(g);

            boolean peng = shells[i].getRect().intersects(plane.getRect());

            if(peng) {
                System.out.println("撞！！！");
                plane.live = false;
            }
        }
        //g.setColor(c);
        //g.setFont(f);
    }

    //反复重画窗口
    class PaintThread extends Thread {
        @Override
        public void run() {
            while(true){
                repaint(); //重画
                //System.out.println("重画");
                try {
                    Thread.sleep(40);//1s25次
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //键盘监听内部类
    class KeyMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            //System.out.println(e.getKeyCode());
            plane.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            //System.out.println(e.getKeyCode());
            plane.minusDirection(e);
        }
    }
    /**
     * 初始化窗口
     */
    public void launchFrame() {
        this.setTitle("游戏人生");
        this.setVisible(true);
        this.setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
        this.setLocation(300,300);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        new PaintThread().start();//启动重画窗口的线程
        addKeyListener(new KeyMonitor());//增加键盘监听

        for(int i=0;i<shells.length;i++) {
            shells[i] = new Shell();
        }
    }

    public static void main(String[] agrs) {
        Game g = new Game();
        g.launchFrame();
    }

    private Image offScreenImage = null;

    public void update(Graphics g) {
        if(offScreenImage == null)
            offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);//这是游戏窗口的宽度和高度

        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }
}
