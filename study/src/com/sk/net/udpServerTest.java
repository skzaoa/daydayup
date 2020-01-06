package com.sk.net;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author sk
 * create on  2020/1/3:22:02
 */
public class udpServerTest implements Runnable{
    public static void dataInputStream() throws IOException {
        System.out.println("接收启动");
        DatagramSocket server = new DatagramSocket(9999);

        //String data = "hi!!!";
        byte[] container = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);
        server.receive(packet);
        byte[] datas = packet.getData();

        DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        String msg = dis.readUTF();
        int age = dis.readInt();
        boolean flag = dis.readBoolean();
        char ch = dis.readChar();

        int len = packet.getLength();
        System.out.println(len);
        System.out.println(new String(datas,0,len));
        System.out.println("msg : "+msg+", age : "+age+", flag : "+flag+", ch : "+ch);
        server.close();
    }

    public static void objectInputStream() throws IOException, ClassNotFoundException {
        System.out.println("接收启动");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        DatagramSocket server = new DatagramSocket(9999);

        //String data = "hi!!!";
        byte[] container = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);
        server.receive(packet);
        byte[] datas = packet.getData();

        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        String msg = ois.readUTF();
        int age = ois.readInt();
        boolean flag = ois.readBoolean();
        char ch = ois.readChar();
        Object emptmp = ois.readObject();
        Object datetmp = ois.readObject();

        Employee emp = null;
        Date date = null;
        if (emptmp instanceof Employee){
            emp = (Employee) emptmp;
        }
        if (datetmp instanceof Date){
            date = (Date) datetmp;
        }

        int len = packet.getLength();
        System.out.println(len);
        System.out.println(new String(datas,0,len));
        System.out.println("msg : " +msg
                +", age : " +age
                +", flag : "+flag
                +", ch : "+ch
                +", emp.getName() : " +emp.getName()
                +", emp.getSalary() : "+emp.getSalary()
                +", df.format(date) : "+df.format(date)  );
        server.close();
    }

    public static void talk() throws IOException {
        System.out.println("接收启动");
        DatagramSocket server = new DatagramSocket(9999);

        //String data = "hi!!!";
        byte[] container = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);

        while (true) {
            server.receive(packet);
            byte[] datas = packet.getData();
            int len = packet.getLength();
            String msg = new String(datas,0,len);
            System.out.println(msg);

            if (msg.equals("bye")){
                break;
            }
        }
        server.close();
    }

    @Override
    public void run() {

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //dataInputStream();
        /*******************************/
        //objectInputStream();
        /*******************************/
        //talk();
        /* ********************************/
    }


}
