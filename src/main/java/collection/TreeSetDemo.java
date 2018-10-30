package collection;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Author: Jakot
 * @Date: 2018/10/25 23:05
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        //String实体类中实现Comparable接口，所以在初始化TreeSet的时候，
        //无需传入比较器
        TreeSet<String> treeSet = new TreeSet<String>();
        treeSet.add("d");
        treeSet.add("c");
        treeSet.add("b");
        treeSet.add("a");
        Iterator<String> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
