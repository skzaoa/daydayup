package com.sk1.server00;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.cert.CRL;
import java.util.Date;

/**
 * @author sk
 * create on  2020/1/7:18:48
 */
public class Server {
    private ServerSocket serverSocket;

    public void start(){
        try {
            serverSocket = new ServerSocket(8888);
            receive();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void receive(){
        try {
            Socket client = serverSocket.accept();
            System.out.println("一个客户端建立了连接");
            Request request = new Request(client);

            System.out.println("--------返回----------");
            Response response = new Response(client);
            response.print("<html>");
            response.print("<head>");
            response.print("<title>");
            response.print("服务器响应成功");
            response.print("</title>");
            response.print("</head>");
            response.print("<body>");
            response.print("终于回来了。。。");
            response.print("</body>");
            response.print("</html>");
            response.pushToBrowser(200);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop(){

    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
}
