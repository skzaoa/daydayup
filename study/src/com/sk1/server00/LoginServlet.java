package com.sk1.server00;


import java.util.Arrays;

/**
 * @author sk
 * create on  2020/1/6:21:37
 */
public class LoginServlet implements Servlet{

    @Override
    public void service(Request request, Response response) {
        response.print("<html>");
        response.print("<head>");
        response.print("<title>");
        response.print("Servlet启动");
        response.print("</title>");
        response.print("</head>");
        response.print("<body>");
        response.print("Servlet终于回来了。。。"+ Arrays.toString(request.getParameterValues("fav")));
        response.print("</body>");
        response.print("</html>");

    }
}
