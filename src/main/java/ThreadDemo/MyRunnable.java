package ThreadDemo;

/**
 * @Author: Jakot
 * @Date: 2018/10/27 19:08
 */
public class MyRunnable implements Runnable{

//    private String title;
//    public MyRunnable(String title) {
//        this.title = title;
//    }
    @Override
    public void run() {
        for (int x = 0; x < 10; x++) {
            //System.out.println(this.title + "运行，x = " + x);
            System.out.println(Thread.currentThread().getName() + "运行，x = " + x);
        }
    }
}
