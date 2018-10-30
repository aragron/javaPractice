package ThreadDemo;

/**
 * @Author: Jakot
 * @Date: 2018/10/28 0:08
 */
public class Interrupted implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            //e.printStackTrace();
            System.out.println("被中断");
        }
    }
}