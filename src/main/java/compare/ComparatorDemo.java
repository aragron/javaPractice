package compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Jakot
 * @Date: 2018/10/25 21:35
 */
public class ComparatorDemo {
    public static void main(String[] args)
    {
        Person p1 = new Person("a", 20);
        Person p2 = new Person("b", 23);
        Person p3 = new Person("c", 10);
        Person p4 = new Person("d", 22);
        Person p5 = new Person("e", 20);
        List<Person> list = new ArrayList<Person>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        for (Person o : list) {
            System.out.println(o.getAge() + "-->" + o.getName());
        }
        System.out.println("----");
        Collections.sort(list, new PersonCompartor());
        for (Person o : list) {
            System.out.println(o.getAge() + "-->" + o.getName());
        }


//        Person[] people=new Person[]{new Person("xujian", 20),new Person("xiewei", 10)};
//        System.out.println("排序前");
//        for (Person person : people)
//        {
//            System.out.print(person.getName()+":"+person.getAge());
//        }
//        Arrays.sort(people,new PersonCompartor());
//        System.out.println("\n排序后");
//        for (Person person : people)
//        {
//            System.out.print(person.getName()+":"+person.getAge());
//        }
    }
}
