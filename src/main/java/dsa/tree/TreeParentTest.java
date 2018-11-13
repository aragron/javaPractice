package dsa.tree;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Jakot
 * @Date: 2018/11/12 0:45
 */
public class TreeParentTest {
    public static void main(String[] args){
        TreeParent<String> tp = new TreeParent<String>("root");
        TreeParent.Node root = tp.root();
        System.out.println(root);
        tp.addNode("节点1",root);
        System.out.println("此树的深度："+tp.deep());
        tp.addNode("节点2",root);
        List<TreeParent.Node<String>> nodes = tp.children(root);
        System.out.println("根节点的第一个子节点："+nodes.get(0));
        //为根节点的第一个子节点新增子节点
        tp.addNode("节点3",nodes.get(0));
        System.out.println("此树的深度："+tp.deep());
        System.out.println(tp.children(nodes.get(0)));
    }
}
