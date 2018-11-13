package dsa.tree;

import java.util.Arrays;

/**
 * @Author: Jakot
 * @Date: 2018/11/12 16:29
 * 二叉树的顺序存储
 */
public class ArrayBinTree<T> {
    //数组记录数的所有节点
    private Object[] datas;
    private int DEFAULT_DEEEP = 8;
    //树的深度
    private int deep;
    private int arraySize;
    //默认深度创建二叉树
    public ArrayBinTree(){
        this.deep = DEFAULT_DEEEP;
        this.arraySize = (int)Math.pow(2,deep) - 1;
        datas = new Object[arraySize];
    }
    //指定深度创建二叉树
    public ArrayBinTree(int deep){
        this.deep = deep;
        this.arraySize = (int)Math.pow(2,deep) - 1;
        datas = new Object[arraySize];
    }
    //指定深度创建二叉树，指定根结点创建二叉树
    public ArrayBinTree(int deep, T data){
        this.deep = deep;
        this.arraySize = (int)Math.pow(2,deep) - 1;
        datas = new Object[arraySize];
        datas[0] = data;
    }
    /*
    * @param index 需要添加子节点的父节点的索引
    * @param data 新子节点的数据
    * @param left是否为左节点
    * */
    public void add(int index, T data, boolean left){
        if (datas[index] == null){
            throw new RuntimeException(index+"处节点为空，无法添加子节点");
        }if (2 * index + 1 >= arraySize){
            throw new RuntimeException("树底层的数组已满，树越界异常");
        }
        //添加左子节点
        if(left){
            datas[2 * index + 1] = data;
        }else {
            datas[2 * index + 2] = data;
        }
    }
    public boolean empty(){
        return datas[0] == null;
    }
    //返回根节点
    public T root(){
        return (T)datas[0];
    }
    //返回指定节点的父节点
    public T parent(int index){
        return (T)datas[(index - 1) / 2];
    }
    //返回指定节点的左子叶结点
    public T left(int index){
        if (2 * index + 1 >= arraySize){
            throw new RuntimeException("该节点为叶子节点，无子节点");
        }
        return (T)datas[index * 2 + 1];
    }
    //返回指定节点的右子叶结点
    public T right(int index){
        if (2 * index + 1 >= arraySize){
            throw new RuntimeException("该节点为叶子节点，无子节点");
        }
        return (T)datas[index * 2 + 2];
    }
    public int deep(int index){
        return deep;
    }
    public int pos(T data){
        for (int i = 0; i < arraySize; i++){
            if (datas[i].equals(data)){
                return i;
            }
        }
        return -1;
    }
    @Override
    public String toString(){
        return Arrays.toString(datas);
    }
}
