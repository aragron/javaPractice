package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: Jakot
 * @Date: 2018/10/25 22:56
 */
public class HashSetDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("Hello");
        set.add("world");
        set.add(null);
        System.out.println("集合的尺寸为:" + set.size());
        System.out.println("集合中的元素为:" + set.toString());

        //遍历集合的第一种方法，使用数组的方法
        String[] strArray = new String[set.size()];
        strArray=set.toArray(strArray);
        for(String str:strArray)//此处也可以使用for(int i=0;i<strArray.length;i++)
        {
            System.out.println(str);
        }
        //遍历集合的第二中方法，使用set集合直接遍历
        for(String str:set)
        {
            System.out.println(str);
        }

        //遍历集合的第三种方法，使用iterator迭代器的方法
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }
}
