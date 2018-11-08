package dsa.stack;

/**
 * @Author: Jakot
 * @Date: 2018/11/5 17:18
 */
public class testArrayStack {
    public static void main(String[] args) {
        ArrayStack as = new ArrayStack(4);
        as.push("a");
        as.push("b");
        as.push("c");
        as.push("d");
        as.printAll();
        System.out.println("=====");
        System.out.println(as.pop());
        System.out.println(as.pop());
        System.out.println(as.pop());
        System.out.println(as.pop());
        System.out.println(as.pop());
        System.out.println("=====");
        as.push("e");
        as.printAll();
        as.push("f");
        as.printAll();
        System.out.println(as.pop());
        System.out.println(as.pop());
        as.push("g");
        as.push("h");
        System.out.println(as.pop());

    }
}
