package ThreadDemo.ali;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * @Author: Jakot
 * @Date: 2018/10/29 1:47
 */
public class ThreadFactoryDemo {
    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ExecutorService pool = new ThreadPoolExecutor(5, 200, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        pool.execute(myRunnable);
        pool.execute(myRunnable);
        pool.execute(myRunnable);
        pool.execute(myRunnable);

        System.out.println("线程池大小："+((ThreadPoolExecutor) pool).getPoolSize());
        System.out.println("队列数："+((ThreadPoolExecutor) pool).getQueue().size());
        System.out.println("已经完成的线程："+((ThreadPoolExecutor) pool).getCompletedTaskCount());
        pool.shutdown();
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
