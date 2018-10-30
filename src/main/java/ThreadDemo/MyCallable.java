package ThreadDemo;

import java.util.concurrent.Callable;

/**
 * @Author: Jakot
 * @Date: 2018/10/27 21:32
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() {
        for (int x = 0; x < 10; x++) {
            System.out.println("*******线程执行，x = " + x);
        }
        return "线程执行完毕";
    }
}
