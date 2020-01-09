package com.sk1.server00;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author sk
 * create on  2020/1/6:21:37
 */
public class LoginServlet implements Servlet{

    @Override
    public void service(Request request, Response response) throws IOException {
        response.print(FileUtils.readFileToString(new File("./study/src/index.html"),"UTF-8"));
    }
}
