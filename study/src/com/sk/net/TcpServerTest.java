package com.sk.net;

import org.apache.commons.io.FileUtils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author sk
 * create on  2020/1/5:12:54
 */
public class TcpServerTest {


    static class Channel implements Runnable{
        private Socket client;
        public Channel(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            //2、阻塞式等待连接accept
            Socket client = this.client;
            System.out.println("一个客户端建立了连接");
            //3、操作：输入输出流
            DataInputStream dis = null;
            DataOutputStream dos = null;
            try {
                dis = new DataInputStream(client.getInputStream());

                String data = dis.readUTF();
                System.out.println(data);

                String uname = null;
                String passwd = null;
                String[] dataArray = data.split("&");
                for(String str:dataArray){
                    String[] userInfo = str.split("=");
                    System.out.println(userInfo[0]+"-->"+userInfo[1]);
                    if (userInfo[0].equals("uname")){
                        System.out.println("用户名："+userInfo[1]);
                        uname = userInfo[1];
                    }
                    if (userInfo[0].equals("passwd")){
                        System.out.println("密码："+userInfo[1]);
                        passwd = userInfo[1];
                    }
                }

                dos = new DataOutputStream(client.getOutputStream());

                assert uname != null;
                assert passwd != null;
                if(uname.equals("sk")&&passwd.equals("111111")){
                    dos.writeUTF("登录成功");
                    System.out.println("登录成功");
                } else {
                    dos.writeUTF("账号或密码错误");
                    System.out.println("账号或密码错误");
                    return;
                }
                dos.flush();

                data = dis.readUTF();
                System.out.println(data);
                String fileName = null;
                String msg = null;
                dataArray = data.split("&&&&&&");
                for(String str:dataArray){
                    String[] userInfo = str.split("======");
                    System.out.println(userInfo[0]+"-->"+userInfo[1]);
                    if (userInfo[0].equals("fileName")){
                        System.out.println("文件名："+userInfo[1]);
                        fileName = userInfo[1];
                    }
                    if (userInfo[0].equals("msg")){
                        System.out.println("文件内容："+userInfo[1]);
                        msg = userInfo[1];
                    }
                }
                FileUtils.writeStringToFile(new File("../tmp/"+fileName),msg,"UTF-8");

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                //4、释放资源

                try {
                    assert dos != null;
                    dos.close();
                    dis.close();
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    public static void main(String[] args) throws IOException {
        //1、指定端口 使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8888);

        boolean flag = true;
        while (flag){
            Socket client = server.accept();
            new Thread(new Channel(client)).start();
        }
        server.close();
    }
}
