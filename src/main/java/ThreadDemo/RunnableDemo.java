package ThreadDemo;

/**
 * @Author: Jakot
 * @Date: 2018/10/27 19:16
 */
public class RunnableDemo {
    public static void main(String[] args) {
        for (int x = 0; x < 3; x ++) {
            String title = "线程对象-" + x;
//            Runnable run = ()->{
//                for (int y = 0; y < 10; y++) {
//                    System.out.println(title + "运行，y = " + y);
//                }
//            };
//            new Thread(run).start();

            new Thread(()->{
                for (int y = 0; y < 10; y++) {
                    System.out.println(title + "运行，y = " + y);
                }
            }).start();
        }
    }
}
