package ThreadDemo.ProducerConsumer;

/**
 * @Author: Jakot
 * @Date: 2018/10/28 11:55
 */
public class Consumer implements Runnable {
    private Message msg;
    public Consumer(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int x = 0; x < 101; x++){
            System.out.println(this.msg.get());
        }
    }
}
