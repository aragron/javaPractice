package ThreadDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Jakot
 * @Date: 2018/10/29 16:22
 */
public class ConditionTest {
    private Lock lock=new ReentrantLock();
    //通过定义多个Condition实现选择性通知,可以唤醒指定种类的线程，这是
    //控制部分线程行为的方便形式
    private Condition conditionA=lock.newCondition();
    private Condition conditionB=lock.newCondition();

    public void awaitA(){
        try {
            lock.lock();
            System.out.println("awaitA begin");
            conditionA.await();
            System.out.println("awaitA end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void awaitB(){
        try {
            lock.lock();
            System.out.println("awaitB begin");
            conditionB.await();
            System.out.println("awaitB end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void signalA(){
        try {
            lock.lock();
            System.out.println("现在开始唤醒awaitA");
            conditionA.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void signalB(){
        try {
            lock.lock();
            System.out.println("现在开始唤醒awaitB");
            conditionB.signalAll();
        }finally {
            lock.unlock();
        }
    }
}
