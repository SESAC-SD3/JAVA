package d.inheritance.practice04;

interface Swimmable {
    void swim();
}

interface Flyable {
    void fly();
}

class Duck implements Swimmable, Flyable {
    private String name;

    public Duck(String name) {
        this.name = name;
    }

    @Override
    public void fly() {
        System.out.println(name + "날아갑니다");
    }

    @Override
    public void swim() {
        System.out.println(name + "수영합니다.");
    }
}
class Fish implements Swimmable {
    private String name;

    public Fish(String name) {
        this.name = name;
    }

    @Override
    public void swim() {
        System.out.println(name + "수영합니다.");
    }
}

public class Practice03 {
    public static void main(String[] args) {
        Duck duck = new Duck("오리");
        duck.swim();
        duck.fly();
        System.out.println();

        Fish fish = new Fish("물고기");
        fish.swim();
        System.out.println();
    }
}
