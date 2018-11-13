package dsa.tree;

/**
 * @Author: Jakot
 * @Date: 2018/11/12 16:54
 */
public class ArrayBinTreeTest {
    public static void main(String[] args){
        ArrayBinTree<String> binTree = new ArrayBinTree<String>(4,"根");
        binTree.add(0,"第2层右子节点",false);
        binTree.add(2,"第3层右子节点",false);
        binTree.add(6,"第4层右子节点",false);

        System.out.println(binTree);

    }
}
