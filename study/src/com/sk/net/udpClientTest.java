package com.sk.net;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Date;

/**
 * @author sk
 * create on  2020/1/3:22:03
 */
public class udpClientTest implements Runnable{
    private  DatagramSocket client ;

    public udpClientTest(int port) {
        try {
            this.client = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }


    public static void dataOutputStream() throws IOException {
        System.out.println("发送启动");
        DatagramSocket client = new DatagramSocket(8888);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
        dos.writeUTF("hi");
        dos.writeInt(18);
        dos.writeBoolean(true);
        dos.writeChar('a');
        dos.flush();

        byte[] datas = baos.toByteArray();
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",9999));
        client.send(packet);
        client.close();
    }

    public static void objectOutputStream() throws IOException {
        System.out.println("发送启动");
        DatagramSocket client = new DatagramSocket(8888);
        //
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(baos));

        oos.writeUTF("hi");
        oos.writeInt(18);
        oos.writeBoolean(true);
        oos.writeChar('a');
        oos.writeObject(new Employee("sk",120.00));
        oos.writeObject(new Date());
        oos.flush();

        byte[] datas = baos.toByteArray();
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",9999));
        client.send(packet);
        client.close();
    }

    public static void talk() throws IOException, InterruptedException {
        System.out.println("发送启动");

        DatagramSocket client = new DatagramSocket(8888);


        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String msg = reader.readLine();
            byte[] datas = msg.getBytes();
            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 9999));
            client.send(packet);
            if(msg.equals("bye")){
                break;
            }
        }
        client.close();
    }

    @Override
    public void run() {

    }

    public static void main(String[] args) throws IOException, InterruptedException {

        //dataOutputStream();
        /* ******************************/
        //Thread.sleep(1000);
        //objectOutputStream();
        /* ********************************/
        //talk();
        /* ********************************/

        /**
         *
         */

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入自己的发送端口：");
        int mySendPort = Integer.parseInt(reader.readLine());
        System.out.println("请输入自己的接收端口：");
        int myRecvPort = Integer.parseInt(reader.readLine());



        System.out.println("mySendPort:"+mySendPort+", myRecvPort:"+myRecvPort);
        TalkRecv tr = new TalkRecv(myRecvPort);
        TalkSend ts = new TalkSend(mySendPort,"localhost");

        new Thread(tr,"recvMsg").start();
        new Thread(ts,"sendMsg").start();


    }
}


class TalkSend implements Runnable{
    private  DatagramSocket client ;
    private  BufferedReader reader ;
    private  String toIP;
    private int port;
    public TalkSend(int port,String toIP) {
        this.toIP = toIP;
        this.port = port;
        try {
            this.client = new DatagramSocket(port);
            this.reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {

            StringBuilder sb = new StringBuilder();
            try {
                System.out.println("请输入对方的端口：");
                int toPort = Integer.parseInt(reader.readLine());
                System.out.println("请输入内容：");
                sb.append("[").append(this.port).append("]").append(reader.readLine());

                byte[] datas = sb.toString().getBytes();
                DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress(this.toIP,toPort));
                System.out.println(Thread.currentThread().getName()+" : "+sb);
                client.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(sb.toString().equals("byebye")){
                break;
            }
        }
        client.close();
    }
}

class TalkRecv implements Runnable{
    private  DatagramSocket server ;

    public TalkRecv(int port) {
        try {
            this.server = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        byte[] container = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);

        while (true) {
            try {
                server.receive(packet);
                byte[] datas = packet.getData();
                int len = packet.getLength();
                String msg = new String(datas,0,len);
                System.out.println(Thread.currentThread().getName()+" : "+msg);

                if (msg.equals("byebye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        server.close();
    }
}