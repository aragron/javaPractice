package obj;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Objects;

/**
 * @Author: Jakot
 * @Date: 2018/10/25 16:57
 */
public class Person  implements Serializable, Comparable<Person> {
    int id;
    String name;
    double height;
    public Person() {}
    public Person(int id, String name, double height)
    {
        this.id = id;
        this.name = name;
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return id == person.id &&
                Double.compare(person.height, height) == 0 &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, height);
    }

    public void write(RandomAccessFile raf) throws IOException
    {
        raf.write(id);
        raf.writeUTF(name);
        raf.writeDouble(height);
    }

    public void read(RandomAccessFile raf) throws IOException
    {
        this.id = raf.readInt();
        this.name = raf.readUTF();
        this.height = raf.readDouble();
    }

    @Override
    public int compareTo(Person o) {
        return this.id - o.getId();
    }
}
