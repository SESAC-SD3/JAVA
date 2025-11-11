package d.inheritance.practice04;

interface Drawable {
    public void draw();
}


class Circle implements Drawable {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("반지름이" + radius + "원을 그립니다.");
    }
}
//class Rectangle implements Drawable {}
//class Triangle implements Drawable {}

public class Practice01 {
    public static void main(String[] args) {
        Circle c = new Circle(5);
        c.draw();
    }
}
