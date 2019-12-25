package com.sk.io;

import java.io.*;

/**
 * @author sk
 * create on  2019/12/24:20:12
 */
public class TestIO {

    private static void testRead(String path){
        //1、创建源
        File src = new File(path);
        InputStream is = null;
        //2、选择流
        try {
            is = new FileInputStream(src);
            int temp;
            //3、操作（读取）
            while (-1!=(temp=is.read())){
                System.out.print((char)temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4、释放资源
            if (null!=is){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 文件字节输出流
     */
    private static void testReadByByte(String path){
        //1、创建源
        File src = new File(path);
        InputStream is = null;
        //2、选择流
        try {
            is = new FileInputStream(src);
            byte[] flush = new byte[3];//缓冲容器
            int len =-1;//接收长度
            //3、操作（读取）
            while (-1!=(len=is.read(flush))){
                String str = new String(flush,0,len);
                System.out.print(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4、释放资源
            if (null!=is){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void testWrite(String path, String msg){
        //1、创建源
        File dest = new File(path);
        OutputStream os = null;
        //2、选择流
        try {
            //os = new FileOutputStream(dest);//覆盖模式
            os = new FileOutputStream(dest,true);//追加方式
            byte[] flush = new byte[1024];//缓冲容器
            int len =-1;//接收Write长度
            //3、操作（读取）
            //String msg = "IO is do easy!!!\r\n";
            byte[] dates = msg.getBytes();
            os.write(dates,0,dates.length);
            os.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、释放资源
            if (null!=os){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void fileCopy(String srcPath, String destPath){
        //1、创建源
        File src = new File(srcPath);
        File dest = new File(destPath);

        InputStream is = null;
        OutputStream os = null;
        //2、选择流
        //2、选择流
        try {
            is = new FileInputStream(src);
            //os = new FileOutputStream(dest,true);//追加方式
            os = new FileOutputStream(dest);//追加方式
            byte[] flush = new byte[3];//缓冲容器
            int len =-1;//接收长度
            //3、操作（读取）
            //3、操作（读取）
            while (-1!=(len=is.read(flush))){
                os.write(flush,0,len);
            }
            os.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、释放资源 先打开的后关闭
            if (null!=os){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //4、释放资源 先打开的后关闭
            if (null!=is){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean deleteFile(File file){
        if(!file.exists()){
            return false;
        }

        if (file.isFile()){
            return file.delete();
        } else {
            File[] files = file.listFiles();
            assert files != null;
            /*
             *  断言
             *  1、assert [boolean 表达式]
             *  如果为true，则程序继续执行。如果为false，则程序抛出AssertionError，并终止执行
             *  2、assert [boolean 表达式:错误表达式（日志）]
             *  如果为true，则程序继续执行。如果为false，则程序抛出java.lang.AssertionError，输出【错误信息】
             */
            for(File f:files){
                deleteFile(f);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String path1 = "./study/src/com/sk/io/123.txt";
        String path2 = "./study/src/com/sk/io/124.txt";
        for (int i = 0; i < 1000; i++) {
            testWrite(path1,i+":\tIO is do easy!!!\r\n");
        }
        testRead(path1);
        System.out.println("\n==================");

        fileCopy(path1,path2);
        testReadByByte(path2);
        System.out.println("\n==================");
        System.out.println("delete : "+path1+" : "+deleteFile(new File(path1)));
        System.out.println("delete : "+path2+" : "+deleteFile(new File(path2)));

        fileCopy("./study/src/images/bj.jpg","./study/src/com/sk/io/bj.jpg");
        System.out.println("delete : ./study/src/com/sk/io/bj.jpg : "+deleteFile(new File("./study/src/com/sk/io/bj.jpg")));

    }
}
