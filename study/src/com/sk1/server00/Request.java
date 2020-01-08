package com.sk1.server00;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.*;

/**
 * @author sk
 * create on  2020/1/7:20:34
 */
public class Request {
    //协议信息
    private String requestInfo;
    //请求方式
    private String method;
    //请求url
    private String url;
    //请求参数
    private String queryStr;
    private Map<String, List<String>> paramaterMap;
    private final String BLANK = " ";
    private final String CRLF = "\r\n";

    public Request(InputStream is) {
        paramaterMap = new HashMap<>();
        byte[] datas = new byte[1024*1024];
        int len = 0;
        try {
            len = is.read(datas);
            this.requestInfo = new String(datas,0,len);

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        //分解协议
        parseRequestInfo();
    }
    public Request(Socket client) throws IOException {
        this(client.getInputStream());
    }

    private void parseRequestInfo(){
        System.out.println("------fenjie-------");
        System.out.println(requestInfo);
        System.out.println("----1、获取请求方式：开头第一个/------");
        this.method = this.requestInfo.substring(0,this.requestInfo.indexOf("/")).toLowerCase();
        this.method = this.method.trim();
        System.out.println("----2、获取请求url：第一个/到HTTP/------");
        System.out.println("----可能包含请求参数？前面的url");
        //1)、获取/
        int startIndex = this.requestInfo.indexOf("/")+1;
        //2)、获取HTTP/的位置
        int endIndex = this.requestInfo.indexOf("HTTP/");
        //3)、分割字符串
        this.url = this.requestInfo.substring(startIndex,endIndex).trim();
        //4)、获取?的位置
        int queryIndex = this.url.indexOf("?");
        if (queryIndex>=0){
            String[] urlArray = this.url.split("\\?");
            this.url = urlArray[0];
            this.queryStr = urlArray[1].trim();
        }
        System.out.println("----3、获取请求参数：如果是Get已经获取，如果是post可能在请求体中------");
        if(this.method.equals("post")){
            String qStr = this.requestInfo.substring(this.requestInfo.lastIndexOf(CRLF)).trim();
            if (null == this.queryStr) {
                this.queryStr = qStr;
            } else if (!qStr.equals("")){
                this.queryStr += "&"+qStr;
            }
        }
        System.out.println(this.method);
        System.out.println(this.url);
        System.out.println(this.queryStr);
        //转成Map fav=1&fav=2&uname=sk&age=18&others=
        convertMap();
    }
    private void convertMap(){
        //1、分割字符串
        String[] keyValues = this.queryStr.split("&");
        for(String qureyStr:keyValues){
            //2、再次分割字符串 =
            String[] keyValue = qureyStr.split("=");
            keyValue = Arrays.copyOf(keyValue,2);
            //获取key value
            String key = keyValue[0];
            String value = keyValue[1]==null?null:decode(keyValue[1],"UTF-8");
            //存到map
            if(!paramaterMap.containsKey(key)){
                paramaterMap.put(key,new ArrayList<String>());
            }
            paramaterMap.get(key).add(value);
        }
    }
    private String decode(String value,String enc){
        try {
            return java.net.URLDecoder.decode(value,enc);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String[] getParameterValues(String key){
        List<String> values = this.paramaterMap.get(key);
        if(null == values || values.size()<1){
            return null;
        }
        return values.toArray(new String[0]);
    }
    public String getParameterValue(String key){
        String[] values = getParameterValues(key);
        return values==null?null:values[0];
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getQueryStr() {
        return queryStr;
    }
}
