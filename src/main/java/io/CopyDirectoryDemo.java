package io;

import java.io.*;

/**
 * @Author: Jakot
 * @Date: 2018/10/24 11:24
 */
public class CopyDirectoryDemo {
    public static void main(String[] args) throws Exception {
        //File file = new File("D:" + File.separator + "hello" );
        if (args.length != 2) {
            System.out.println("命令执行错误，参数为两个");
            System.exit(1);
        }
        long start = System.currentTimeMillis();
        FileUtil fu = new FileUtil(args[0], args[1]);
        if (new File(args[0]).isFile()) {
            System.out.println(fu.copy() ? "文件拷贝成功！" : "文件拷贝失败！");
        } else if (new File(args[0]).isDirectory()) {
            System.out.println(fu.copyDir() ? "文件夹拷贝成功！" : "文件夹拷贝失败！");
        }
        long end = System.currentTimeMillis();
        System.out.println("拷贝时间：" + (end - start));
    }
}
class FileUtil {
    private File srcFile;
    private File desFile;
    public FileUtil(String src, String des) {
        this(new File(src), new File(des));
    }
    public FileUtil(File srcFile, File desFile) {
        this.srcFile = srcFile;
        this.desFile = desFile;
    }
    public boolean copy() throws Exception {
        if (!this.srcFile.exists()) {
            System.out.println("拷贝源文件不存在！");
            return false;
        }
        return this.copyFileImpl(this.srcFile, this.desFile);
    }
    public boolean copyDir() throws Exception {
        try {
            this.copyImpl(this.srcFile);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    private void copyImpl(File file) throws Exception {
        if (file.isDirectory()) {
            File results [] = file.listFiles();
            if (results != null) {
                for  (int x = 0; x < results.length; x++) {
                    copyImpl(results[x]);
                }
            }
        } else if (file.isFile()) {
            String newFilePath = file.getPath().replace(this.srcFile.getPath()+ File.separator,"");
            File newfile = new File(this.desFile, newFilePath);
            this.copyFileImpl(file, newfile);
        } else {}
    }
    private boolean copyFileImpl(File srcFile, File desFile) throws IOException {
        if (!desFile.getParentFile().exists()) {
            desFile.getParentFile().mkdirs();
        }
        //byte [] data = new byte[1024];
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(srcFile);
            output = new FileOutputStream(desFile);
            input.transferTo(output);
            //int len = 0;
            //while ((len = input.read(data)) != -1) {
            //  output.write(data, 0, len);
            //}
            return true;
        } catch (IOException e) {
            throw e;
        } finally {
            if (input != null) {
                input.close();
            }
            if (output != null) {
                output.close();
            }
        }
    }
}