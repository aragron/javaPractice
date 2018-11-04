package dsa.linkedlist;

import java.util.ArrayList;

/**
 * 单链表实现
 * @Author: Jakot
 * @Date: 2018/11/1 10:52
 */
public class SingleLinkedList<T> {
    //链表节点的个数
    private int size;
    //定义头节点
    private Node<T> head;

    SingleLinkedList(){
        this.size = 0;
        this.head = null;
    }
    //链表的每个节点类
    public static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return this.data;
        }
    }

    public int getSize(){
        return this.size;
    }

    protected Node<T> createNode(T data) {
        return new Node<>(data, null);
    }

    public boolean isEmpty(){
        System.out.println("\r\nThe length of the Linkedlist is: " + this.size);
        return (this.head == null);
    }

    void printAll() {
        Node<T> p = this.head;

        ArrayList<T> elementList = new ArrayList<>();
        while (p != null){
            elementList.add(p.data);
            p = p.next;
        }
        System.out.println(elementList);
        System.out.println("The length of the Linkedlist is: " + this.size);
    }

    //从链表头插入
    public void insertHead(Node<T> p){
        if (this.head == null){
            this.head = p;
        }else {
            p.next = this.head;
            this.head = p;
        }
        ++this.size;
    }
    void insertHead(T data){
        Node<T> p = new Node<>(data,null);
        insertHead(p);
    }
    //搜索
    public ArrayList<T> searchByValue(T data){
        Node<T> p = this.head;
        ArrayList<T> indexList = new ArrayList<>();
        for (int i = 0; i < this.size; ++i){
            if (p.data.equals(data)){
                indexList.add(data);
            }
            p = p.next;
        }
        return indexList;
    }
    public Node<T> searchByIndex(int index){
        if (index < 0 || index > this.size){
            return null;
        }
        int i = 0;
        Node<T> p = this.head;
        while (p != null && i < index){
            p = p.next;
            ++i;
        }
        return p;
    }
    //在链表头删除元素
    public boolean deleteHead(){
        head = this.head.next;
        --this.size;
        return true;
    }
    public boolean deleteByNode(Node<T> p){
        if (p == null || this.head == null) {
            return false;
        }

        if (p == this.head) {
            this.head = this.head.next;
            --this.size;
            return true;
        }

        Node<T> q = this.head;
        while (q != null && q.next != p) {
            q = q.next;
        }
        if (q == null){
            return false;
        }
        q.next = q.next.next;
        --this.size;
        return true;
    }
    //删除值的第一个节点
    public boolean deleteByValue(T data) {
        Node<T> p = this.head;
        if (p.data.equals(data)){
            this.head = this.head.next;
            --this.size;
            return true;
        }
        while (p.next != null && !p.next.data.equals(data)){
            p = p.next;
        }
        if(p.next == null){
            return false;
        }
        p.next = p.next.next;
        --this.size;
        return true;
    }
    //删除值的所有节点
    public void deleteAllByValue(T data){
        while (this.head != null && this.head.data.equals(data)) {
            this.head = this.head.next;
            --this.size;
        }
        Node<T> p = this.head;
        assert p != null;
        while (p.next != null){
            if (p.next.data.equals(data)){
                p.next = p.next.next;
                --this.size;
                continue;
            }
            p = p.next;
        }
    }
    public boolean deleteByIndex(int index){
        //--index;
        if (index < 0 || index > this.size){
            return false;
        }
        if (index == 0) {
            this.head = this.head.next;
            return true;
        }
        int i = 0;
        Node<T> p = this.head;
        while (p != null && i < index - 1){
            p = p.next;
            ++i;
        }
        assert p != null;
        p.next = p.next.next;
        --this.size;
        return true;
    }
    public boolean clearAll(){
        this.head.data = null;
        this.head.next = null;
        this.size = 0;
        return true;
    }

    public boolean insertByIndex(Node<T> p, int index){
        if (index < 0 || index > this.size){
            return false;
        }
        if (index == 0){
            insertHead(p);
            return true;
        }

        int i = 0;
        Node<T> q = this.head;
        while (i < index - 1){
            q = q.next;
            ++i;
        }
        Node<T> tmp = q.next;
        q.next = p;
        p.next = tmp;
        ++this.size;
        return true;
    }
    public boolean insertByIndex(T data, int index){
        Node<T> p = new Node<>(data,null);
        return  insertByIndex(p, index);
    }
    public void append(Node<T> p){
        if (this.head == null){
            this.head = p;
            ++this.size;
            return;
        }
        Node<T> q = this.head;
        while (q.next != null){
            q = q.next;
        }
        q.next = p;
        ++this.size;
    }
    public void append(T data){
       Node<T> p = new Node<>(data,null);
       append(p);
    }

    //快慢指针判断是否有环，并且找出环的入口
    public boolean hasLoop(){
        if (this.head == null || this.head.next == null){
            return false;
        }
        Node<T> pSlow = this.head;
        Node<T> pFast = this.head;
        while (pFast != null && pFast.next != null){
            pSlow = pSlow.next;
            pFast = pFast.next.next;
            if(pFast == pSlow){
                pSlow = this.head;
                while (pSlow != pFast){
                    pSlow = pSlow.next;
                    pFast = pFast.next;
                }
                //打印环的入口节点数据
                System.out.println(pSlow.getData());
                return true;
            }
        }
        return false;
    }
    public Node<T> getHead(){
        return this.head;
    }
    public Node<T> getTail(){
        if (this.head == null || this.hasLoop()){
            return null;
        }
        Node<T> p = this.head;
        while (p.next != null){
            p = p.next;
        }
        return p;
    }

    public void splice(SingleLinkedList<T> sl){
        //sl.head = this.getTail().next;
        this.getTail().next = sl.head;
        this.size += sl.getSize();
    }

    public SingleLinkedList<T> reversal(){
        SingleLinkedList<T> s = new SingleLinkedList<>();
        Node<T> p = this.head;
        Node<T> q = null;

        while (p != null){
            q = p.next;
            p.next = null;
            s.insertHead(p);
            p = q;
        }
        return s;
    }
}