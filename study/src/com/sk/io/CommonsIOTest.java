package com.sk.io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author sk
 * create on  2019/12/29:19:20
 */
public class CommonsIOTest {
    public static void main(String[] args) throws IOException {
        long len = FileUtils.sizeOf(new File("study/src/com/sk/io/CommonsIOTest.java"));
        System.out.println(len);
        len = FileUtils.sizeOf(new File("study\\src\\com\\sk\\io"));
        System.out.println(len);

        System.out.println("-------0-------");
        Collection<File> files = FileUtils.listFiles(new File("study\\src\\com\\sk"), EmptyFileFilter.NOT_EMPTY,null);
        for(File f:files){
            System.out.println(f.getAbsolutePath());
        }
        System.out.println("-------1-------");

        files = FileUtils.listFiles(new File("study\\src\\com\\sk"), EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);
        for(File f:files){
            System.out.println(f.getAbsolutePath());
        }
        System.out.println("------2--------");

        files = FileUtils.listFiles(new File("study\\src\\com\\sk"),
                FileFilterUtils.or(new SuffixFileFilter("copy"),EmptyFileFilter.NOT_EMPTY), DirectoryFileFilter.INSTANCE);
        for(File f:files){
            System.out.println(f.getAbsolutePath());
        }
        System.out.println("------3--------");

        //读取内容
        String msg = FileUtils.readFileToString(new File("study\\src\\com\\sk\\io\\CommonsIOTest.java"),"UTF-8");
        System.out.println(msg);
        System.out.println("------4--------");

        byte[] dates = FileUtils.readFileToByteArray(new File("study\\src\\com\\sk\\io\\CommonsIOTest.java"));
        System.out.println(dates.length);
        System.out.println("------5--------");

        List<String> masgs = FileUtils.readLines(new File("study\\src\\com\\sk\\io\\CommonsIOTest.java"),"UTF-8");
        for(String s:masgs){
            System.out.println(s);
        }
        System.out.println("------6--------");

        LineIterator  it = FileUtils.lineIterator(new File("study\\src\\com\\sk\\io\\CommonsIOTest.java"),"UTF-8");
        while (it.hasNext()){
            System.out.println(it.nextLine());
        }
        System.out.println("------7--------");

        //写出文件
        FileUtils.write(new File("../tmp/haha.txt"),"hahahahahahahaha\r\n","UTF-8");
        FileUtils.writeStringToFile(new File("../tmp/haha.txt"),"heiheihiehei\r\n","UTF-8",true);
        FileUtils.writeByteArrayToFile(new File("../tmp/haha.txt"),"hehehehehehe\r\n".getBytes("UTF-8"),true);
        System.out.println("------8--------");

        //写出列表
        List<String> lists = new ArrayList<>();
        lists.add("sk1");
        lists.add("sk2");
        lists.add("sk3");
        FileUtils.writeLines(new File("../tmp/haha.txt"),lists,"---",true);
        System.out.println("------9--------");

        //复制文件
        FileUtils.copyFile(new File("../tmp/haha.txt"),new File("../tmp/haha_copy.txt"));
        FileUtils.copyFileToDirectory(new File("../tmp/haha.txt"),new File("../tmp/122"));
        FileUtils.copyDirectoryToDirectory(new File("../tmp/123"),new File("../tmp/122"));
        FileUtils.copyDirectory(new File("../tmp/123"),new File("../tmp/122"));

        String url = "http://www.tupian1.cn/uploads/allimg/150420/1-150420010447-50.jpg";
        FileUtils.copyURLToFile(new URL(url),new File("../tmp/1.jpg"));

        msg = IOUtils.toString(new URL("http://www.baidu.com"),"UTF-8");
        System.out.println(msg);
        msg = IOUtils.toString(new URL("http://www.163.com"),"gbk");
        System.out.println(msg);
        System.out.println("------10--------");

        System.out.println("------11--------");
        System.out.println("------12--------");
        System.out.println("------13--------");
        System.out.println("------14--------");
        System.out.println("------15--------");
    }

}
