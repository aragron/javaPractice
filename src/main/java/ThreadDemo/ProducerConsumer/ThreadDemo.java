package ThreadDemo.ProducerConsumer;

/**
 * @Author: Jakot
 * @Date: 2018/10/28 11:58
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Message msg = new Message();
        new Thread(new Producer(msg)).start();
        new Thread(new Consumer(msg)).start();
    }
}
