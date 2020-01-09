package com.sk1.server00;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * @author sk
 * create on  2020/1/7:18:48
 */
public class Server {
    private ServerSocket serverSocket;
    private boolean isRunning;
    public void start(){
        try {
            serverSocket = new ServerSocket(8888);
            this.isRunning = true;
            receive();
        } catch (IOException e) {
            e.printStackTrace();
    }

    }

    private void receive(){
        while (isRunning) {
            try {
                Socket client = serverSocket.accept();
                System.out.println("一个客户端建立了连接");
                new Thread(new Dispatcher(client)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop(){
        this.isRunning = false;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
}
