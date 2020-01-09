package com.sk1.server00;

import java.io.IOException;

/**
 * @author sk
 * create on  2020/1/8:21:18
 */
public interface Servlet {
    void service(Request request,Response response) throws IOException;
}
