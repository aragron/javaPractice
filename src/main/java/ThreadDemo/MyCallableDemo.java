package ThreadDemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: Jakot
 * @Date: 2018/10/27 21:35
 */
public class MyCallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(new MyCallable());
        new Thread(task).start();
//        new Thread(task).start();
//        new Thread(task).start();
//        String str = task.get();
//        System.out.println(str);
    }
}
