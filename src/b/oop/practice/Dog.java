package b.oop.practice;

public class Dog {
    String breed;
    String name;

    public Dog(String breed, String name) {
        this.breed = breed;
        this.name = name;
    }

    public void sit() {
        System.out.println(name + "앉았습니다.");
    }
    public void hand() {
        System.out.println(name + "손!");
    }
}
