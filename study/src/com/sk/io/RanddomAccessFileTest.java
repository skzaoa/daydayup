package com.sk.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author sk
 * create on  2019/12/28:20:12
 * 文件分割
 * 文件合并
 */
public class RanddomAccessFileTest {

    private  File src ;
    private String destDir;
    private List<String> destDirPath;
    private int blockSize;
    private int size;
    /**
     *
     */
    private int actualSize;
    private long len;

    public RanddomAccessFileTest(File src, String destDir, int blockSize) {
        this.src = src;
        this.destDir = destDir;
        this.blockSize = blockSize;
        this.destDirPath = new ArrayList<String>();

        init();
    }

    private void init(){
        long len = this.src.length();
        this.size = (int) Math.ceil(len*1.0/blockSize);
        for (int i = 0; i < size; i++) {
            this.destDirPath.add(this.destDir+"/"+i+"-"+this.src.getName());
        }
        this.actualSize = blockSize>len? (int) len :blockSize;

    }

    public void split() throws IOException {
        long len = src.length();
        System.out.println(size);

        int beginPos = 0;


        for (int i = 0; i < size; i++) {
            beginPos = i*blockSize;
            if (i == size-1){
                actualSize = (int) len;
            } else {
                actualSize = blockSize;
                len -= actualSize;
            }
            System.out.println("\n"+i+"-->"+beginPos+"-->"+actualSize);

            splitDetail(i,beginPos);
        }
    }



    /**
     * 指定第i块起始位置和实际长度，
     * @param pos 第几块
     * @param beginPos 起始位置
     * @throws IOException
     */
    private void splitDetail(int pos, int beginPos) throws IOException {

        RandomAccessFile raf = new RandomAccessFile(this.src,"r");
        RandomAccessFile raf2 = new RandomAccessFile(new File(this.destDirPath.get(pos)),"rw");
        System.out.println(this.destDirPath.get(pos));
        raf.seek(beginPos);

        byte[] flush = new byte[actualSize];
        int len = -1;
        while (-1 != (len = raf.read(flush))){

            if (actualSize>len){
                System.out.print(new String(flush,0,len));
                raf2.write(flush,0,len);
                actualSize -= len;
            } else {
                System.out.print(new String(flush,0,actualSize));
                raf2.write(flush,0,actualSize);
                break;
            }
        }
        raf2.close();
        raf.close();

    }

    public void merge(String destPath) throws IOException {
        //输出流
        OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath,true));
        //输入流
        for (int i = 0; i <destDirPath.size() ; i++) {
            InputStream is = new BufferedInputStream(new FileInputStream(destDirPath.get(i)));
            byte[] flush = new byte[actualSize];
            int len = -1;
            while (-1 != (len = is.read(flush))){
                os.write(flush,0,len);
            }

            os.flush();
            is.close();
        }

        os.close();
    }

    public void mergeBySequenceInputStream(String destPath) throws IOException {
        //输出流
        OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath,true));
        Vector<InputStream> vi = new Vector<>();
        //输入流
        for (int i = 0; i <destDirPath.size() ; i++) {
            vi.add(new BufferedInputStream(new FileInputStream(destDirPath.get(i))));
        }
        SequenceInputStream sis = new SequenceInputStream(vi.elements());
        byte[] flush = new byte[actualSize];
        int len = -1;
        while (-1 != (len = sis.read(flush))){
            os.write(flush,0,len);
        }
        os.flush();
        sis.close();
        os.close();
    }
    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        RanddomAccessFileTest raft = new RanddomAccessFileTest(new File("../tmp/1.txt"),"../tmp",10);
        raft.split();

        raft.merge("../tmp/2.txt");
        raft.mergeBySequenceInputStream("../tmp/3.txt");
    }
}
