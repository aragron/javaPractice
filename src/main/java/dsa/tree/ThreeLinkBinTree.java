package dsa.tree;

import com.sun.source.tree.Tree;

import javax.management.relation.RoleUnresolved;

/**
 * @Author: Jakot
 * @Date: 2018/11/12 19:20
 */
public class ThreeLinkBinTree<E> {
    public static class TreeNode{
        Object data;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        public TreeNode(){}
        public TreeNode(Object data){
            this.data = data;
        }
        public TreeNode(Object data, TreeNode left, TreeNode right, TreeNode parent){
            this.data = data;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }
    private TreeNode root;
    public ThreeLinkBinTree(){
        this.root = new TreeNode();
    }
    /*
    * @param index 父节点的索引
    * @param data 新的子节点的数据
    * @param isLeft 是否为左节点
    * @return 新增的节点
    * */
    public TreeNode addNode(TreeNode parent, E data, boolean isLeft){
        if (parent == null){
            throw new RuntimeException(parent + "节点为null，无法添加子节点");
        }
        if (isLeft && parent.left != null){
            throw new RuntimeException("节点已有左子节点，无法添加到左子节点");
        }
        if (!isLeft && parent.right != null){
            throw new RuntimeException("节点已有右子节点，无法添加到右子节点");
        }
        TreeNode newNode = new TreeNode(data);
        if (isLeft){
            parent.left = newNode;
        }else {
            parent.right = newNode;
        }
        newNode.parent = parent;
        return newNode;
    }
    public boolean empty(){
        return root.data == null;
    }
    public TreeNode root(){
        if (empty()){
            throw new RuntimeException("树为空，无法访问根节点");
        }
        return root;
    }
    public E parent(TreeNode node){
        if (node == null){
            throw new RuntimeException(node + "节点为空，无法访问其父节点");
        }
        return (E)node.parent.data;
    }
    public E leftChild(TreeNode parent){
        if (parent == null){
            throw new RuntimeException(parent + "节点为null，无法添加子节点");
        }
        return parent.left == null ? null : (E)parent.left.data;
    }
    public E rightChild(TreeNode parent){
        if (parent == null){
            throw new RuntimeException(parent + "节点为null，无法添加子节点");
        }
        return parent.left == null ? null : (E)parent.right.data;
    }
    public int deep(){
        return deep(root);
    }
    public int deep(TreeNode node){
        if (node == null){
            return 0;
        }
        if (node.left == null && node.right == null){
            return 1;
        } else {
            int leftDeep = deep(node.left);
            int rightDeep = deep(node.right);
            int max = leftDeep > rightDeep ? leftDeep : rightDeep;
            return max + 1;
        }
    }
}
