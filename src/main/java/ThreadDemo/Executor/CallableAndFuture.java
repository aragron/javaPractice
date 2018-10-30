package ThreadDemo.Executor;

import java.util.concurrent.*;

/**
 * @Author: Jakot
 * @Date: 2018/10/28 17:02
 */
public class CallableAndFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        //接受一上callable实例
        Future<String> future = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "MOBIN";
            }
        });
        System.out.println("任务的执行结果："+future.get());
    }
}