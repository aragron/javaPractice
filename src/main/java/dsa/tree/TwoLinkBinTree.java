package dsa.tree;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Jakot
 * @Date: 2018/11/12 17:14
 */
public class TwoLinkBinTree<E> {
    public static class TreeNode{
        Object data;
        TreeNode left;
        TreeNode right;
        public TreeNode(){}
        public TreeNode(Object data){
            this.data = data;
        }
        public TreeNode(Object data, TreeNode left, TreeNode right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    private TreeNode root;
    //以默认的构造器创建二叉树
    public TwoLinkBinTree(){
        this.root = new TreeNode();
    }
    public TwoLinkBinTree(E data){
        this.root = new TreeNode(data);
    }
    /*
     * @param index 需要添加子节点的父节点的索引
     * @param data 新子节点的数据
     * @param isLeft是否为左节点
     * @return 新增的节点
    * */
    public TreeNode addNode(TreeNode parent, E data, boolean isLeft){
        if(parent == null){
            throw new RuntimeException("节点为null，无法添加子节点");
        }
        if (isLeft && parent.left != null){
            throw new RuntimeException(parent + "节点已经有子节点，无法添加左子节点");
        }
        if (!isLeft && parent.right != null){
            throw new RuntimeException(parent + "节点已经有子节点，无法添加左右子节点");
        }
        TreeNode newNode = new TreeNode(data);
        if (isLeft){
            parent.left = newNode;
        }else {
            parent.right = newNode;
        }
        return newNode;
    }
    public boolean empty(){
        return root.data == null;
    }
    public TreeNode root(){
        if(empty()){
            throw new RuntimeException("树为空，无法访问根节点");
        }
        return root;
    }
    //返回指定节点的父节点
    public E parent(TreeNode node){
        //对于二叉链表存储法，如果要访问指定节点的父节点必须遍历二叉树
        return null;
    }
    //返回指定节点的左子节点
    public E leftChild(TreeNode parent){
        if (parent == null){
            throw new RuntimeException(parent + "节点为空，无法添加子节点");
        }
        return parent.left == null ? null : (E)parent.left.data;
    }
    //返回指定节点的右子节点，当右子节点不存在时返回null
    public E rightChild(TreeNode parent){
        if (parent == null){
            throw new RuntimeException(parent + "节点为null，无法添加子节点");
        }
        return parent.right == null ? null : (E)parent.right.data;
    }
    public int deep(){
        return deep(root);
    }
    private int deep(TreeNode node){
        if (node == null){
            return 0;
        }
        if (node.left == null && node.right == null){
            return 1;
        }else {
            int leftDeep = deep(node.left);
            int rightDeep = deep(node.right);
            int max = leftDeep> rightDeep ? leftDeep : rightDeep;
            return max + 1;
        }
    }

    //先序遍历
    public List<TreeNode> preIterator(){
        return preIterator(root);
    }
    private List<TreeNode> preIterator(TreeNode node){
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(node);
        if (node.left != null){
            list.addAll(preIterator(node.left));
        }
        if (node.right != null){
            list.addAll(preIterator(node.right));
        }
        return list;
    }
    //中序遍历
    public List<TreeNode> inIterator(){
        return inIterator(root);
    }
    private List<TreeNode> inIterator(TreeNode node){
        List<TreeNode> list = new ArrayList<TreeNode>();
        if(node.left != null){
            list.addAll(inIterator(node.left));
        }
        list.add(node);
        if (node.right != null){
            list.addAll(inIterator(node.right));
        }
        return list;
    }
    //后续遍历
    public List<TreeNode> postIterator(){
        return postIterator(root);
    }
    private List<TreeNode> postIterator(TreeNode node){
        List<TreeNode> list = new ArrayList<TreeNode>();
        if(node.left != null){
            list.addAll(inIterator(node.left));
        }
        if (node.right != null){
            list.addAll(inIterator(node.right));
        }
        list.add(node);
        return list;
    }
    //广度优先
    public List<TreeNode> breadthFirst(){
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        List<TreeNode> list = new ArrayList<TreeNode>();
        if (root != null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            list.add(queue.peek());
            TreeNode p = queue.poll();
            if(p.left != null){
                queue.offer(p.left);
            }
            if(p.right != null){
                queue.offer(p.right);
            }
        }
        return list;
    }
}
