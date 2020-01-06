package com.sk.net;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.Socket;

/**
 * @author sk
 * create on  2020/1/5:12:54
 */
public class TcpClientTest {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名：");
        String uname = console.readLine();
        System.out.println("请输入密码：");
        String passwd = console.readLine();
        //1、建立连接
        Socket client = new Socket("localhost",8888);

        //2、操作：输入输出流
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());

        dos.writeUTF("uname="+uname+"&"+"passwd="+passwd);
        dos.flush();

        DataInputStream dis = new DataInputStream(client.getInputStream());
        String data = dis.readUTF();
        System.out.println(data);

        File file = new File("study\\src\\com\\sk\\TestFile\\TestFile.java");
        String msg  = FileUtils.readFileToString(file,"UTF-8");
        dos.writeUTF("fileName======"+file.getName()+"&&&&&&"+"msg======"+msg);
        dos.flush();

        //3、释放资源
        dis.close();
        dos.close();
        client.close();


    }
}
