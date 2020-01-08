package com.sk1.server00;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author sk
 * create on  2020/1/8:22:10
 */
public class WebHandler  extends DefaultHandler {
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
                    for(Iterator<String> iter = mapping.getPatterns().iterator(); iter.hasNext();){
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
