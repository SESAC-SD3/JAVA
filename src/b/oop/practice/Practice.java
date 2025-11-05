package b.oop.practice;

public class Practice {
    public static void main(String[] args) {
        Person p = new Person("kim", 20);
        p.printInfo();

        Dog d = new Dog("진돗개", "백구");
        d.sit();

        Car c = new Car("A", 0);
        c.printInfo();
        c.accelerate();
        c.printInfo();
        c.brake();
        c.printInfo();

        BankAccount ba = new BankAccount("1234-1234", 0);
        ba.deposit(10000);
        ba.withdraw(1000);
        System.out.println(ba.balance);

        Counter count =  new Counter();
        count.increment();
        count.increment();
        count.decrement();
        System.out.println(count.count);

    }
}
