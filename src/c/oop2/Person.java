package c.oop2;


public class Person {
    String name;
    int age;
    String address;

    // new Person();
    public Person() {
        this.name = "noname";
        this.age = 0;
    }

    // new Person("kim", 10);
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // new Person("Lee", 20, "seoul");
    public Person(String name, int age, String address) {
        // this.name = name;
        // this.age = age;
        this(name, age);
        this.address = address;
    }

}
