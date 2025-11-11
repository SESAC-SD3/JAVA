package d.inheritance;

class Animal7 {
    void eat() {
        System.out.println("eating");
    }
}

interface Swimmable {
    void swim();
    //void swiming();
}
interface Flyable {
    void fly();
}
interface Walkable {
    void walk();
}

class Duck implements Swimmable, Flyable, Walkable {
    @Override
    public void fly() {
        System.out.println("오리가 날아갑니다.");
    }

    @Override
    public void swim() {
        System.out.println("오리가 수영합니다.");
    }

    @Override
    public void walk() {
        System.out.println("오리가 걸어다닙니다.");
    }
    // swimming()
}
class Fish extends Animal7 implements Swimmable {
    @Override
    public void swim() {
        System.out.println("물고기가 수영합니다.");
    }
}

public class MultiInterfaceMain {
    public static void main(String[] args) {
        Duck duck = new Duck();
        Fish fish = new Fish();

        duck.swim();
        duck.fly();

        fish.swim();
    }
}
