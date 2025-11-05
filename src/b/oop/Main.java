package b.oop;

public class Main {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(10, 20);
        // Circle c1 = new Circle(10);

        Rectangle r2 = new Rectangle(20, 20);
        Rectangle r3 = new Rectangle(100, 100);

        System.out.println(r1);
        System.out.println(r2);

        System.out.println(r1.width);
        System.out.println(r1.area());

        // -----

        Circle c1 = new Circle(10);
        Circle c2 = new Circle(20);
        Circle c3 = c2;

        c1.radius = 100;
        c2.radius = 200;

        System.out.println(c1.radius);
        System.out.println(c2.radius);
        System.out.println(c3.radius);

        Rectangle r4 = null;

        // -----

        Dog d1 = new Dog("뽀삐", 2, "말티즈");
        System.out.println(d1.name);
        System.out.println(d1.age);

    }
}
