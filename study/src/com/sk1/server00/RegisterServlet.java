package com.sk1.server00;

/**
 * @author sk
 * create on  2020/1/8:21:23
 */
public class RegisterServlet implements Servlet{
    @Override
    public void service(Request request, Response response) {
        response.print("注册成功，哈哈");
    }
}
