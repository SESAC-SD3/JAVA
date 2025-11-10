package d.inheritance;

import java.util.Objects;

class MyObject {
    String name;
    int value;

    public MyObject(String name, int value) {
        this.name = name;
        this.value = value;
    }

//    @Override
//    public String toString() {
//        return "name = " + name + " value = " + value;
//    }

    @Override
    public String toString() {
        return "MyObject{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MyObject myObject = (MyObject) o;
        return value == myObject.value && Objects.equals(name, myObject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }
}

public class ObjectMain {
    public static void main(String[] args) {
        MyObject obj = new MyObject("test", 100);
//        System.out.println(obj.name);
//        System.out.println(obj.value);
        System.out.println(obj.toString());
        System.out.println(obj);

        MyObject obj2 = new MyObject("test", 101);

        System.out.println(obj.equals(obj2));
    }
}






