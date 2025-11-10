package d.inheritance.practice01;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("hello" + name + age);
    }
}

class Student extends Person{
    String studentId;
    String major;

    public Student(String name, int age, String studentId, String major) {
        super(name, age);
        this.studentId = studentId;
        this.major = major;
    }

    @Override
    public void introduce() {
//        super.introduce();
        System.out.println("hello" + name + age + major + studentId);
    }
}

public class Practice01 {
    public static void main(String[] args) {
        Student s = new Student("kim", 10, "a123", "computer");
        s.introduce();
    }
}
