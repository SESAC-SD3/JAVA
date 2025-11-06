package c.oop2;

public class Main {
    public static void main(String[] args) {
        Calulator cal = new Calulator();

        int result = cal.add(2, 3);
        int result2 = cal.add(4, 5, 6);
        int result3 = cal.add(1, 2, 3, 4, 5);
        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);

        Person person = new Person();
        Person person2 = new Person("Kim", 20);
        // Person person3 = new Person("Lee");
        Person person3 = new Person("Lee", 30, "seoul");


        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(10);
        Rectangle r3 = new Rectangle(20, 30);
    }
}
