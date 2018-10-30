package compare;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Jakot
 * @Date: 2018/10/23 14:42
 */
public class ComparableDemo {
    public static void main(String[] args) throws ParseException {

        ComparableDemoClass f1 = new ComparableDemoClass("tony", 19);
        ComparableDemoClass f2 = new ComparableDemoClass("jack", 16);
        ComparableDemoClass f3 = new ComparableDemoClass("tom", 80);
        ComparableDemoClass f4 = new ComparableDemoClass("jbson", 44);
        ComparableDemoClass f5 = new ComparableDemoClass("jason", 44);

        List<ComparableDemoClass> list = new ArrayList<ComparableDemoClass>();
        list.add(f1);
        list.add(f3);
        list.add(f4);
        list.add(f2);
        list.add(f5);
        //调用 Collections.sort(): 实质是调用Arrays.sort
        Collections.sort(list);

        for (ComparableDemoClass o : list) {
            System.out.println(o.getAge() + "-->" + o.getName());
        }
    }
}
