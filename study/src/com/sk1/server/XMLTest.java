package com.sk1.server;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author sk
 * create on  2020/1/5:21:02
 */



class PersonHandler extends DefaultHandler {
    private List<Person> persons;
    private Person person;
    private String tag;
    @Override
    public void startDocument() throws SAXException {
        persons = new ArrayList<Person>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName+"-->解析开始");
        if (null != qName){
            tag = qName;
        }
        if(tag.equals("person")){
            person = new Person();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch,start,length);

        if (null != tag) {
            if (tag.equals("name")) {
                if (contents.length()>0) {
                    person.setName(contents);
                }
            } else if (tag.equals("age")) {
                if (contents.length()>0) {
                    person.setAge(Integer.valueOf(contents));
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName + "-->解析结束"+qName);
        if (null != qName) {
            if (qName.equals("person")) {
                persons.add(person);

            }
        }
        tag = null;
    }

    @Override
    public void endDocument() throws SAXException {
        //System.out.println("-->解析结束");
    }

    public List<Person> getPersons() {
        return persons;
    }
}

public class XMLTest {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //SAX解析
        //1、获取解析工厂
        SAXParserFactory factory=SAXParserFactory.newInstance();
        //2、从解析工厂获取解析器
        SAXParser parse =factory.newSAXParser();
        //3、编写处理器
        //4、加载文档 Document 注册处理器
        PersonHandler handler=new PersonHandler();
        parse.parse(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/sk1/server/p.xml")),handler );

        //获取数据
        List<Person> persons = handler.getPersons();
        for (Person person:persons){
            System.out.println(person.getName()+"-->"+person.getAge());
        }
    }
}
