package com.sk1.server;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @author sk
 * create on  2020/1/5:21:02
 */



class WebHandler extends DefaultHandler {
    private List<Entity> entitys;
    private List<Mapping> mappings;
    private Entity entity;
    private Mapping mapping;
    private String tag;
    private boolean isMapping;
    private boolean isEndMapping;
    @Override
    public void startDocument() throws SAXException {
        entitys = new ArrayList<Entity>();
        mappings = new ArrayList<Mapping>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName+"-->解析开始");
        if (null != qName){
            tag = qName;
        }

        if(tag.equals("servlet")){
            entity = new Entity();
            isMapping = false;
        }
        if(tag.equals("servlet-mapping")){
            mapping = new Mapping();
            isMapping = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch,start,length);

        if (null != tag) {
            if (!isMapping){
                if (tag.equals("servlet-name")) {
                    if (contents.length()>0) {
                        entity.setName(contents);
                    }
                } else if (tag.equals("servlet-class")) {
                    if (contents.length()>0) {
                        entity.setClz(contents);
                    }
                }
            } else {
                if (tag.equals("servlet-name")) {
                    if (contents.length()>0) {
                        mapping.setName(contents);
                    }
                } else if (tag.equals("url-pattern")) {
                    if (contents.length()>0) {
                        mapping.addPattern(contents);
                    }
                }
            }

        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName + "-->解析结束"+qName);
        if (null != qName) {
            if (!isMapping){
                if (qName.equals("servlet")) {
                    entitys.add(entity);
                    entity = null;

                }
            } else {
                if (qName.equals("servlet-mapping")) {
                    mappings.add(mapping);
                    for(Iterator<String> iter = mapping.getPatterns().iterator();iter.hasNext();){
                        System.out.println(iter.next());
                    }
                    mapping = null;
                }
            }
        }
        tag = null;
    }

    @Override
    public void endDocument() throws SAXException {
        //System.out.println("-->解析结束");
    }

    public List<Entity> getEntitys() {
        return entitys;
    }

    public List<Mapping> getMappings() {
        return mappings;
    }
}

public class ParseWebXML {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //SAX解析
        //1、获取解析工厂
        SAXParserFactory factory=SAXParserFactory.newInstance();
        //2、从解析工厂获取解析器
        SAXParser parse =factory.newSAXParser();
        //3、编写处理器
        //4、加载文档 Document 注册处理器
        WebHandler handler=new WebHandler();
        parse.parse(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/sk1/server/web.xml")),handler );

        System.out.println("----entities-------");
        //获取数据
        List<Entity> entities = handler.getEntitys();
        for (Entity entity:entities){
            System.out.println(entity.getName()+"-->"+entity.getClz());
        }
        System.out.println("----mappings-------");
        List<Mapping> mappings = handler.getMappings();
        System.out.println(mappings.size());
        for (Mapping mapping:mappings){
            System.out.println(mapping.getName()+"-->"+mapping.getPatterns());
        }

        System.out.println("----context-------");
        WebContext context = new WebContext(handler.getEntitys(),handler.getMappings());
        Class clz = Class.forName(context.getClz("/g"));
        Servlet servlet = (Servlet)clz.newInstance();
        System.out.println(servlet);
        servlet.service();

        clz = Class.forName(context.getClz("/login"));
        servlet = (Servlet)clz.newInstance();
        System.out.println(servlet);
        servlet.service();

        clz = Class.forName(context.getClz("/reg"));
        servlet = (Servlet)clz.newInstance();
        System.out.println(servlet);
        servlet.service();
    }
}
