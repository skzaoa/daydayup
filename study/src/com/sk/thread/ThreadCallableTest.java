package com.sk.thread;

import java.util.concurrent.*;

/**
 * @author sk
 * create on  2020/1/1:8:28
 */
public class ThreadCallableTest implements Callable<Boolean> {
    private String url;
    private String name;

    public ThreadCallableTest(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownloadTest wdt = new WebDownloadTest();
        wdt.download(url,name);
        return  true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        String url1 = "http://pic1.win4000.com/wallpaper/9/598984337b733.jpg";
        String name1 = "../tmp/1.jpg";
        String url2 = "http://pic1.win4000.com/wallpaper/9/5989843594c87.jpg";
        String name2 = "../tmp/2.jpg";
        String url3 = "http://pic1.win4000.com/wallpaper/9/5989842ac75c1.jpg";
        String name3 = "../tmp/3.jpg";

        //1、创建目标对象
        ThreadCallableTest tct1 = new ThreadCallableTest(url1,name1);
        ThreadCallableTest tct2 = new ThreadCallableTest(url2,name2);
        ThreadCallableTest tct3 = new ThreadCallableTest(url3,name3);
        //2、创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);
        //3、提交执行
        Future<Boolean> result1 = ser.submit(tct1);
        Future<Boolean> result2 = ser.submit(tct2);
        Future<Boolean> result3 = ser.submit(tct3);
        //4、获取结果
        boolean r1 = result1.get();
        boolean r2 = result2.get();
        boolean r3 = result3.get();
        System.out.println("r1:"+r1+", r2"+r2+", r3"+r3);
        //5、
        ser.shutdown();

    }
}
