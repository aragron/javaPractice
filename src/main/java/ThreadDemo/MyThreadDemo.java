package ThreadDemo;

/**
 * @Author: Jakot
 * @Date: 2018/10/27 18:32
 */
public class MyThreadDemo {
    public static void main(String[] args)  {
        //线程对象只允许启动一次
        new MyThread("线程A").start();
        new MyThread("线程B").start();
        new MyThread("线程C").start();
    }
}
