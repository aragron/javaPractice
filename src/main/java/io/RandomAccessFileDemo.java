package io;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * @Author: Jakot
 * @Date: 2018/10/25 17:03
 */
public class RandomAccessFileDemo {
    public static void main(String[] args) throws Exception {

        File file = new File("D:\\test\\flink-annotations\\pom.xml");

        RandomAccessFile raf = new RandomAccessFile(file,"r");

        String temp = null;
        while ((temp = raf.readLine()) != null) {
            if (temp.length() > 0) {
                System.out.println(temp);
                System.out.println(raf.getFilePointer());
            }

        }

    }
}
