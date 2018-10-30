package ThreadDemo.ali;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.ScheduledExecutorService;

import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @Author: Jakot
 * @Date: 2018/10/29 1:34
 */
public class ScheduledExecutorDemo {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(15,
                new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());

        executorService.execute(myRunnable);
        executorService.execute(myRunnable);
        executorService.execute(myRunnable);

        System.out.println("队列数："+((ScheduledThreadPoolExecutor) executorService).getQueue().size());
        System.out.println("线程池大小："+((ScheduledThreadPoolExecutor) executorService).getPoolSize());
        System.out.println("已经完成的线程："+((ScheduledThreadPoolExecutor) executorService).getCompletedTaskCount());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();

    };
    private static Runnable myRunnable = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " run time:" + System.currentTimeMillis() + ",random:" + (int)(Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

}
