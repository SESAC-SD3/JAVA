package b.oop.practice;

public class Car {
    String model;
    int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    public void printInfo() {
        System.out.println(model + speed);
    }

    public void accelerate() {
        speed += 10;
        System.out.println(speed);
    }
    public void brake() {
        speed -= 10;
        System.out.println(speed);
    }
}
