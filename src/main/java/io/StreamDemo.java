package io;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Author: Jakot
 * @Date: 2018/10/25 9:12
 */
public class StreamDemo {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        File file = new File("D:\\迅雷下载\\[电影天堂www.dy2018.com]摩天营救HD韩版中字.mkv");
        File writefile = new File("D:\\test\\cp.mkv");
        InputStream input = new FileInputStream(file);
        OutputStream output = new FileOutputStream(writefile);



        //每次读取一个字节，速度很慢
//        int byteLen = -1;
//        while ((byteLen = input.read()) != -1) {
//            output.write(byteLen);
//        }

        //使用数组作为缓冲，每次读取字节数为数组buffer的长度，但是每次写入数组长度，而不是实际内容的长度
//        byte [] buffer = new byte [1024 * 1024];
//        while (input.read(buffer) != -1) {
//            output.write(buffer);
//        }


        //使用数组缓冲，但是每次写入实际读取内容的长度
//        byte [] buffer = new byte [1024 * 1024];
//        int length = -1;
//        while ((length = input.read(buffer)) != -1) {
//            output.write(buffer, 0, length);
//        }

        //jdk9开始提供的转存方法
        input.transferTo(output);

        input.close();
        output.close();
        long end = System.currentTimeMillis();
        System.out.println("拷贝时间：" + (end - start));
    }
}
