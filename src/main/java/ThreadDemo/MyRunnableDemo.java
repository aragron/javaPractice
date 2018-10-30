package ThreadDemo;

/**
 * @Author: Jakot
 * @Date: 2018/10/27 19:09
 */
public class MyRunnableDemo {
    public static void main(String[] args) {
//        Thread threadA = new Thread(new MyRunnable("线程A"));
//        Thread threadB = new Thread(new MyRunnable("线程B"));
//        Thread threadC = new Thread(new MyRunnable("线程C"));

//        threadA.start();
//        threadB.start();
//        threadC.start();
//        System.out.println(new Thread(new MyRunnable("线程D")).getPriority());

//        MyRunnable myrunnable = new MyRunnable("线程:");
//        new Thread(myrunnable,"A").start();
//        new Thread(myrunnable,"B").start();
//        new Thread(myrunnable,"C").start();
        MyRunnable myrunnable = new MyRunnable();
        Thread threadA = new Thread(myrunnable,"线程对象A");
        Thread threadB = new Thread(myrunnable,"线程对象B");
        Thread threadC = new Thread(myrunnable,"线程对象C");
        threadA.setPriority(Thread.MIN_PRIORITY);
        threadB.setPriority(Thread.MIN_PRIORITY);
        threadC.setPriority(Thread.MAX_PRIORITY);
        threadA.start();
        threadB.start();
        threadC.start();
        System.out.println(new Thread(new MyRunnable(),"线程对象D").getPriority());

    }
}
