package dsa.queue;

/**
 * @Author: Jakot
 * @Date: 2018/11/5 19:48
 */
public class ArrayQueue {
    private String[] items;
    private int n = 0;

    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity){
        this.items = new String[capacity];
        this.n = capacity;
    }

    public boolean enqueue(String item){
        if (this.tail == n){
            if (this.head == 0){
                return false;
            }
            for (int i = this.head; i < this.tail; ++i){
                this.items[i-this.head] = this.items[i];
            }
            this.tail -= this.head;
            this.head = 0;
        }
        this.items[this.tail] = item;
        ++this.tail;
        return true;
    }

    public String dequeue(){
        if (this.head == this.tail){
            return null;
        }
        String ret = this.items[this.head];
        ++this.head;
        return ret;
    }

}
