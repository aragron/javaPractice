package ThreadDemo.ali;

/**
 * @Author: Jakot
 * @Date: 2018/10/29 17:26
 */
public class ThreadPoolHelperDemo {
    public static void main(String[] args) {

        ThreadPoolHelper.executeTask(() -> System.out.println(Thread.currentThread().getName()));
        ThreadPoolHelper.executeTask(() -> System.out.println(Thread.currentThread().getName()));
        ThreadPoolHelper.executeTask(() -> System.out.println(Thread.currentThread().getName()));
        ThreadPoolHelper.executeTask(() -> System.out.println(Thread.currentThread().getName()));
        ThreadPoolHelper.executeTask(() -> System.out.println(Thread.currentThread().getName()));
        ThreadPoolHelper.shutdown();

    }
}
