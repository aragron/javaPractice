package dsa.linkedlist;

import javax.print.attribute.standard.NumberUp;

/**
 * @Author: Jakot
 * @Date: 2018/11/1 11:11
 */
public class testSingleLinkedList {
    public static void main(String[] args) {
        SingleLinkedList<String> sl = new SingleLinkedList<>();
        SingleLinkedList<String> sl2 = new SingleLinkedList<>();

        SingleLinkedList.Node<String> a = sl.createNode("a");
        SingleLinkedList.Node<String> b = sl.createNode("b");
        SingleLinkedList.Node<String> c = sl.createNode("c");
        SingleLinkedList.Node<String> d = sl.createNode("d");
        SingleLinkedList.Node<String> e = sl.createNode("e");
        SingleLinkedList.Node<String> f = sl.createNode("f");
        SingleLinkedList.Node<String> g = sl.createNode("g");
        SingleLinkedList.Node<String> h = sl.createNode("h");

        System.out.println(sl.isEmpty());
        sl.append(b);
        sl.insertHead(a);
        sl.append(c);
        sl.append(d);
        sl.append(e);
        sl.append(f);
        sl.append(g);
        sl.append("h");
        //sl.append(d);
        sl.insertHead("x");
        sl.insertByIndex(h,3);
        sl.insertByIndex("h",0);
        sl.insertByIndex("h",0);
        sl.insertByIndex("h",0);
        sl.insertByIndex("y",9);
        //sl.append(f);

        System.out.println(sl.isEmpty());
        System.out.println(sl.hasLoop());
        System.out.println(sl.getSize());

        sl.printAll();
        System.out.println(sl.searchByValue("h"));
        System.out.println(sl.searchByIndex(9).getData());
        //sl.deleteHead();
        sl.printAll();
        sl.deleteByNode(f);
        sl.printAll();
        System.out.println("-----------------");
        //System.out.println(sl.hasLoop());
        sl.deleteByValue("x");
        sl.deleteAllByValue("h");
        sl.printAll();
        sl.deleteByIndex(2);
//        sl.printAll();

        sl.printAll();
        System.out.println("-----------------");
        //sl.hasLoop();
        System.out.println("-----------------");
        System.out.println(sl.getTail().getData());

        sl2.append("m");
        sl2.append("n");
        sl2.append("l");

        sl.splice(sl2);
        sl.printAll();
    }
}
