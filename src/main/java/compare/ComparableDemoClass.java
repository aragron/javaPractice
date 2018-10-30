package compare;

/**
 * @Author: Jakot
 * @Date: 2018/10/23 14:33
 */
public class ComparableDemoClass implements Comparable<ComparableDemoClass>{
    private String name;
    private int age;

    public ComparableDemoClass() {
    }
    public ComparableDemoClass(String name, int age) {
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
    //类中实现接口Comparable, 调用compareTo方法： 如果 返回值大于0，则将大的数放后面；
    // 如果返回值等于0，则不做任何处理; 如果返回值小于0， 则将小的数放前面。也就是说 java默认的排序方式是升序排序
    @Override
    public int compareTo(ComparableDemoClass o) {
        // 先按age排序
        if (this.age > o.getAge()) {
            return (this.age - o.getAge());
        }
        if (this.age < o.getAge()) {
            return (this.age - o.getAge());
        }

        // 按name排序
        if (this.name.compareTo(o.getName()) > 0) {
            return 1;
        }
        if (this.name.compareTo(o.getName()) < 0) {
            return -1;
        }
        return 0;
    }
}
