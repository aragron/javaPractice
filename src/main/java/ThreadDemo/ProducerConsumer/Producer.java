package ThreadDemo.ProducerConsumer;

/**
 * @Author: Jakot
 * @Date: 2018/10/28 11:51
 */
public class Producer implements Runnable {
    private Message msg;
    public Producer(Message msg){
        this.msg = msg;
    }
    @Override
    public void run() {
        for (int x = 0; x < 100; x++){
            if (x % 2 == 0) {
                this.msg.set(Integer.toString(x),"efgh");
            }else {
                this.msg.set(Integer.toString(x),"航空母舰");
            }
        }
    }
}
