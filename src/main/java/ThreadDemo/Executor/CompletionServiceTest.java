package ThreadDemo.Executor;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @Author: Jakot
 * @Date: 2018/10/28 17:27
 */
public class CompletionServiceTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(10);        //创建含10.条线程的线程池
        CompletionService completionService = new ExecutorCompletionService(executor);
        for (int i =1; i <=10; i ++) {
            final  int result = i;
            completionService.submit(new Callable() {
                @Override
                public Object call() throws Exception {
                    Thread.sleep(new Random().nextInt(100));   //让当前线程随机休眠一段时间
                    return result;
                }
            });
        }
        System.out.println(completionService.take().get());   //获取执行结果
    }
}