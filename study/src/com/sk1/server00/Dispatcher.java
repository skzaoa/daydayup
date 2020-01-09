package com.sk1.server00;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author sk
 * create on  2020/1/9:18:51
 */
public class Dispatcher implements Runnable{
    private Socket client;
    private Request request;
    private Response response;

    public Dispatcher(Socket client) {
        this.client = client;
        try {
            this.request = new Request(client);
            this.response = new Response(client);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void release(){
        try {
            this.client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {

        try {
            String url = request.getUrl();
            if (null == url || url.equals("") ){
                response.print(FileUtils.readFileToString(new File("./study/src/index.html"),"UTF-8"));
                response.pushToBrowser(200);
                return;
            }
            Servlet servlet = MyWeb.getServletFromUrl(request.getUrl());
            if (servlet != null) {
                servlet.service(request,response);
                System.out.println("return status 200");
                response.pushToBrowser(200);
             }else{
            //错误
                System.out.println("return status 404");
                response.pushToBrowser(404);
            }
        }catch (IOException| IllegalAccessException | InstantiationException e) {
            try {
                response.pushToBrowser(505);
                System.out.println("return status 505");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }catch ( ClassNotFoundException | NullPointerException e) {
            System.out.println("return status 404");
            try {
                response.print(FileUtils.readFileToString(new File("./study/src/error.html"),"UTF-8"));
                response.pushToBrowser(404);
            } catch (IOException ee) {
                ee.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            this.release();
        }
    }
}
