package ThreadDemo.ProducerConsumer;

/**
 * @Author: Jakot
 * @Date: 2018/10/28 11:47
 */
public class Message {
    private String title;
    private String content;
    private boolean flag;//true为允许生产，不允许消费；false为允许消费，不允许生产
    public synchronized void set(String title, String content) {
        if (this.flag == false){
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.title = title;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.content = content;
        this.flag = false;//已经生产，等待消费
        super.notify();
    }
    public synchronized String get() {
        if (this.flag == true){
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            return this.title + this.content;
        } finally {
            this.flag = true;
            super.notify();
        }
    }
}
