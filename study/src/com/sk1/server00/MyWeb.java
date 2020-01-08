package com.sk1.server00;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.List;
import java.util.Objects;

/**
 * @author sk
 * create on  2020/1/8:22:05
 */
public class MyWeb {
    private static WebContext webContext;
    static {
        try {
            //SAX解析
            //1、获取解析工厂
            SAXParserFactory factory=SAXParserFactory.newInstance();
            //2、从解析工厂获取解析器
            SAXParser parse =factory.newSAXParser();
            //3、编写处理器
            //4、加载文档 Document 注册处理器
            WebHandler handler=new WebHandler();
            parse.parse(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream("web.xml")),handler );

            System.out.println("----context-------");
            webContext = new WebContext(handler.getEntitys(),handler.getMappings());

        }catch (Exception e){
            System.out.println("解析配置文件错误");
        }
    }

    public static Servlet getServletFromUrl(String url){
        Class clz = null;
        try {
            clz = Class.forName(webContext.getClz("/"+url));
            Servlet servlet = (Servlet)clz.newInstance();
            System.out.println(servlet);
            return servlet;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

}
