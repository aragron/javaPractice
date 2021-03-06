package dsa.tree;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jakot
 * @Date: 2018/11/11 22:47
 */
public class TreeParent<E> {
    public static class Node<T>{
        T data;
        //父节点位置
        int parent;
        public Node(){}
        public Node(T data){
            this.data = data;
        }
        public Node(T data, int parent){
            this.data = data;
            this.parent = parent;
        }
        @Override
        public String toString(){
            return "TreeParent$Node [data="+data+",parent="+parent+"]";
        }
    }

    private final int DEFAULT_TREE_SIZE = 100;
    private int treeSize = 0;
    //使用一个Node[]数组来记录该树里的所有节点
    private Node<E> [] nodes;
    //记录节点数
    private int nodeNums;
    //以指定的根节点创建树
    public TreeParent(E data){
        treeSize = DEFAULT_TREE_SIZE;
        nodes = new Node[treeSize];
        nodes[0] = new Node<E>(data, -1);
        nodeNums++;
    }
    //以指定根节点、指定treeSize创建树
    public TreeParent(E data, int treeSize){
        this.treeSize = treeSize;
        nodes = new Node[treeSize];
        nodes[0] = new Node<E>(data, -1);
        nodeNums++;
    }
    //以指定节点添加子节点
    public void addNode(E data, Node parent){
        for (int i = 0; i < treeSize; i++){
            //找到数组中第一个为null的元素，该元素保存新节点
            if (nodes[i] == null){
                //创建新节点，并用指定的数组元素保存它
                nodes[i] = new Node(data, pos(parent));
                nodeNums++;
                return;
            }
        }
        throw new RuntimeException("该树已经满，无法添加新节点");
    }

    //判断树是否为空
    public boolean empty(){
        return nodes[0] == null;
    }
    //返回根节点
    public Node<E> root() {
        return nodes[0];
    }
    //返回指定节点的父节点
    public Node<E> parent(Node node){
        return nodes[node.parent];
    }
    //返回指定节点的所有子节点
    public List<Node<E>> children(Node parent){
        List<Node<E>> list = new ArrayList<Node<E>>();
        for (int i = 0; i< treeSize; i++){
            if (nodes[i] != null && nodes[i].parent == pos(parent)){
                list.add(nodes[i]);
            }
        }
        return list;
    }
    //返回该树的深度
    public int deep(){
        int max = 0;
        for (int i = 0; i< treeSize && nodes[i] != null; i++){
            int def = 1;
            int m = nodes[i].parent;
            while (m != -1 && nodes[m] != null){
                m = nodes[m].parent;
                def++;
            }
            if (max < def){
                max = def;
            }
        }
        return max;
    }
    //返回包含指定值的节点
    public int pos(Node node){
        for (int i = 0; i < treeSize; i++){
            if (nodes[i] == node){
                return i;
            }
        }
        return -1;
    }
}
