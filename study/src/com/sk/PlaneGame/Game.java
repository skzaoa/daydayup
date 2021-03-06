package com.sk.PlaneGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

/**
 * @author sk
 * create on  2019/12/4:20:47
 */
public class Game extends Frame {

    Image fjImg = GameUtil.getImage("images/fj.png");
    Image bjImg = GameUtil.getImage("images/bj.jpg");
    //int fjX = 250,fjY = 250;
    Plane plane = new Plane(fjImg,250,250);
    Shell[] shells = new Shell[Constant.GAME_SHELL_TIMES];
    Explode bao;
    Date startTime1 = new Date();//启动时间
    Date startTime; //倒计时结束，游戏真正开始时间
    Date endTime;
    int period;
    int iCount = Constant.GAME_INTERVAL_TIME;
    int daoJiSHiTime;
    int baoCount;
    int baoCount1;

    @Override
    public void paint(Graphics g){
        //自动被调用，g相当于一只画笔
        Color c = g.getColor();
        Font f = g.getFont();
        //g.setColor(Color.red);
        //g.drawLine(100,100,100,300);
        //g.drawImage(ball,100,100,null);
        g.drawImage(bjImg,0,0,null);
        //g.drawImage(fjImg,fjX,fjY,null);
        //fjX++;
        plane.drawSelf(g);

        if (iCount < Constant.GAME_PREPARTATION_TIME){
            daoJiSHiTime = (Constant.GAME_PREPARTATION_TIME-iCount)/1000;
            endTime = new Date();
            //System.out.println(".."+(endTime.getTime()-startTime1.getTime())/1000);//游戏启动时间
            System.out.println("倒计时"+daoJiSHiTime+"秒");//倒计时
            g.setColor(Color.red);
            g.setFont(new Font("宋体",Font.BOLD,50));
            g.drawString("倒计时"+daoJiSHiTime+"秒",250-50*5/2,250);

            /*try {
                Thread.sleep(1000-40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

            if (iCount == Constant.GAME_PREPARTATION_TIME-Constant.GAME_INTERVAL_TIME*1) {//提前40ms开启键盘监听
                System.out.println(iCount);
                this.addKeyListener(new KeyMonitor());//增加键盘监听
                //iCount++;
                System.out.println("键盘"+iCount+".");
            }
            return;
            //iCount++;
        }

        if (startTime == null) {
            startTime = new Date();
        }

        //shell.draw(g);
        for(int i=0;i<shells.length;i++) {
            shells[i].draw(g);

            boolean peng = shells[i].getRect().intersects(plane.getRect());
            if(peng && plane.live) {
                System.out.println("撞！！！");
                plane.live = false;
                if (bao == null) {
                    bao = new Explode(plane.x,plane.y);
                    endTime = new Date();
                    period = (int)(endTime.getTime()-startTime.getTime())/1000;
                }
            }
        }

        if (bao != null && bao.count <16) {
            while (true) {
                bao.draw(g);
                baoCount++;
                System.out.println("bao.count=" + bao.count + " baoCount=" + baoCount);
                /**
                 * 爆炸效果时间 baoCount/baoCount1
                 */
                if (baoCount == 5) {
                    bao.count++;
                    baoCount = 0;
                }
                baoCount1++;
                if (baoCount1%5 == 0) {
                    break;
                }
            }
        }
        if (!plane.live) {
            g.setColor(Color.red);
            g.setFont(new Font("宋体",Font.BOLD,50));
            g.drawString("时间："+period+"秒",(int)plane.x,(int)plane.y);
        }
        g.setColor(c);
        g.setFont(f);
    }

    //反复重画窗口
    class PaintThread extends Thread {
        @Override
        public void run() {
            while(true){
                repaint(); //重画
                //System.out.println("重画");
                //if (iCount==0)
                //
                //iCount++;
                try {
                    if (iCount < Constant.GAME_PREPARTATION_TIME) {
                        iCount += Constant.GAME_INTERVAL_TIME;
                    }
                    Thread.sleep(Constant.GAME_INTERVAL_TIME);//1s25次
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
        this.setLocation(900,300);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        for(int i=0;i<shells.length;i++) {
            shells[i] = new Shell();
        }
        new PaintThread().start();//启动重画窗口的线程
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
