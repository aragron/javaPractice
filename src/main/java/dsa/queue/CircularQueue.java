package dsa.queue;

/**
 * @Author: Jakot
 * @Date: 2018/11/5 20:03
 */
public class CircularQueue {
    private String[] items;
    private int n = 0;

    private int head = 0;
    private int tail = 0;

    public CircularQueue(int capacity){
        this.items = new String[capacity];
        this.n = capacity;
    }

    public boolean enqueue(String item){
        if ((this.tail + 1) % n == this.head){
            return false;
        }
        this.items[this.tail] = item;
        this.tail = (this.tail + 1) % n;
        return true;
    }

    public String dequeue(){
        if (this.head == this.tail){
            return null;
        }
        String ret = this.items[this.head];
        this.head = (this.head + 1) % n;
        return ret;
    }

}
