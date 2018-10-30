package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;

/**
 * @Author: Jakot
 * @Date: 2018/10/25 1:22
 */
public class BufferedDemo {
    public static void main(String[] args) throws Exception {
        File file = new File("D:\\test\\flink-annotations\\pom.xml");
        File writefile = new File("D:\\test.txt");

        FileReader reader = new FileReader(file);
        FileWriter writer = new FileWriter(writefile);
        BufferedReader bufferedReader = new BufferedReader(reader);
        BufferedWriter bufferedwriter = new BufferedWriter(writer);

        String temp = null;
        //按行读取，按行写入
        while ((temp = bufferedReader.readLine()) != null) {
            if (temp.length() > 0) {
                bufferedwriter.write(temp);
                bufferedwriter.write("\r\n");
                System.out.println(temp);
            }
        }
        bufferedReader.close();
        bufferedwriter.close();
        reader.close();
        writer.close();
    }
}
