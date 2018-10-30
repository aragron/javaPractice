package compare;

import java.util.Comparator;

/**
 * @Author: Jakot
 * @Date: 2018/10/25 21:36
 */
public class PersonCompartor implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2)
    {
        //return o1.getAge()-o2.getAge();

        // 先按age排序
        if (o1.age > o2.getAge()) {
            return (o1.age - o2.getAge());
        }
        if (o1.age < o2.getAge()) {
            return (o1.age - o2.getAge());
        }

        // 按name排序
        if (o1.name.compareTo(o2.getName()) > 0) {
            return 1;
        }
        if (o1.name.compareTo(o2.getName()) < 0) {
            return -1;
        }
        return 0;
    }
}

