package compare;

/**
 * @Author: Jakot
 * @Date: 2018/10/25 21:32
 */
public class Person {
    String name;
    int age;
    public Person() {}
    public Person(String name, int age)    {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
