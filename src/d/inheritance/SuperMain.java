package d.inheritance;

class Animal2 {
    String name;
    int age;
    String breed;

    // Animal2() {}

    Animal2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void introduce() {
        System.out.println("hello" + this.name + this.age);
    }
}
class Dog2 extends Animal2 {
    String breed;

    // 생성자매서드가 없는경우
    Dog2 () {
        // Animal2("name", 0)
        super("name", 0);
    }

    Dog2(String name, int age, String breed) {
        super(name, age);
        // Animal2(name, age)
        // this.name = name;
        // this.age = age;

        this.breed = breed;
    }

    void display() {
        System.out.println(this.breed);
        System.out.println(super.breed);
        System.out.println(breed);
    }

    void introduce() {
        // Animal2.introduce();
        super.introduce();
        System.out.println("멍멍");

    }
}

public class SuperMain {
    public static void main(String[] args) {
        Animal2 a = new Animal2("동물", 0);
        Dog2 d = new Dog2("초코", 3, "말티즈");

        System.out.println(a.breed);
        System.out.println(d.breed);

        d.display();

        d.introduce();
        a.introduce();

    }
}
