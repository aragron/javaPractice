package ThreadDemo;

/**
 * @Author: Jakot
 * @Date: 2018/10/27 18:29
 */
public class MyThread extends Thread {
    private String title;
    public MyThread(String title) {
        this.title = title;
    }
    @Override
    public void run() {
        for (int x = 0; x < 10; x++) {
            System.out.println(this.title + "运行，x = " + x);
        }
    }
}
