package ThreadDemo.ali;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * @Author: Jakot
 * @Date: 2018/10/29 17:14
 */
public class ThreadPoolHelper {

    private static final int POOL_SIZE = 40;//线程池大小

    //订单任务线程池

    private static ThreadPoolExecutor comitTaskPool =(ThreadPoolExecutor) new ScheduledThreadPoolExecutor(POOL_SIZE,
            new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());


    /**
     * 执行订单任务
     *
     * @param comitTask
     */
    public static void executeTask(Runnable comitTask) {
        comitTaskPool.execute(comitTask);

        System.out.println("【线程池任务】线程池中线程数：" + comitTaskPool.getPoolSize());
        System.out.println("【线程池任务】队列中等待执行的任务数：" + comitTaskPool.getQueue().size());
        System.out.println("【线程池任务】已执行完任务数：" + comitTaskPool.getCompletedTaskCount());
    }


    /**
     * 关闭线程池
     */
    public static void shutdown() {
        System.out.println("shutdown comitTaskPool...");
        comitTaskPool.shutdown();
        try {
            if (!comitTaskPool.isTerminated()) {
                System.out.println("直接关闭失败[" + comitTaskPool.toString() + "]");
                comitTaskPool.awaitTermination(3, TimeUnit.SECONDS);
                if (comitTaskPool.isTerminated()) {
                    System.out.println("成功关闭[" + comitTaskPool.toString() + "]");
                } else {
                    System.out.println("[" + comitTaskPool.toString() + "]关闭失败，执行shutdownNow...");
                    if (comitTaskPool.shutdownNow().size() > 0) {
                        System.out.println("[" + comitTaskPool.toString() + "]没有关闭成功");
                    } else {
                        System.out.println("shutdownNow执行完毕，成功关闭[" + comitTaskPool.toString() + "]");
                    }
                }
            } else {
                System.out.println("成功关闭[" + comitTaskPool.toString() + "]");
            }
        } catch (InterruptedException e) {
            System.out.println("接收到中断请" + comitTaskPool.toString() + "停止操作");
        }
    }
}