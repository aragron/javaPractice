package dsa.tree;

/**
 * @Author: Jakot
 * @Date: 2018/11/9 17:14
 */
public class Node {
    Person person;
    Node leftChild;
    Node rightChild;

    public Node(Person person){
        this.person = person;
    }

    @Override
    public String toString() {
        //System.out.println("name:"+this.person.getName()+",age:"+this.person.getAge());
        return "name:"+this.person.getName()+",age:"+this.person.getAge();
    }
}
