package ThreadDemo;

/**
 * @Author: Jakot
 * @Date: 2018/10/28 0:06
 */
public class InterruptedDemo {
    public static void main(String[] args) throws InterruptedException {
        Interrupted mt = new Interrupted();
        Thread th = new Thread(mt);
        th.start();
        Thread.sleep(1000);
        if (!th.isInterrupted()) {
            System.out.println("中断线程");
            th.interrupt();
        }
    }
}

