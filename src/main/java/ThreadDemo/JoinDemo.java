package ThreadDemo;

/**
 * @Author: Jakot
 * @Date: 2018/10/28 1:23
 */
public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        Thread thread = new Thread(()->{
            for (int x = 0; x < 100; x ++){
                if (x == 3) {
                    try {
                        mainThread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行x = " + x);
            }
        },"子线程");
        thread.start();
        for (int x = 0; x < 100; x++){
            Thread.sleep(100);
            System.out.println("主线程 number = " + x);
        }
    }
}
