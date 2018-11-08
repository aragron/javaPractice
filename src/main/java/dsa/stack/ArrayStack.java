package dsa.stack;

import java.util.Arrays;

/**
 * @Author: Jakot
 * @Date: 2018/11/5 16:47
 */
public class ArrayStack {
    private String [] items;
    //栈中元素的个数
    private int count;
    //栈的大小
    private int n;

    public ArrayStack(int n){
        this.items = new String[n];
        this.n = n;
        this.count = 0;
    }

    public boolean push(String item){
        if (this.count == this.n ){return false;}
        this.items[this.count] = item;
        ++this.count;
        return true;
    }

    public String pop(){
        if (this.count == 0){
            return null;
        }
        String item = this.items[this.count - 1];
        --this.count;
        return item;
    }

    public void printAll(){
        for (int i = 0; i < n; ++i){
            String value = this.items[i];
            if (value != null){
                System.out.println(value);
            }
        }
    }

}
