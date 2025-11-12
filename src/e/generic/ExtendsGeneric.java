package e.generic;
class NumberBox<T extends Number> {
    private T value;

    public NumberBox(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
    public double getDoubleValue() {
        return value.doubleValue();
    }

}

class SortedBox<T extends Comparable<T>> {
    private T value;

    public SortedBox(T value) {
        this.value = value;
    }
    public boolean isGreaterThan(T other) {
        return value.compareTo(other) > 0;
    }
}

public class ExtendsGeneric {
    public static void main(String[] args) {
        NumberBox<Integer> nb1 = new NumberBox<>(10);
        int i = nb1.getValue();
        nb1.getDoubleValue();

        NumberBox<Double> nb2 = new NumberBox<>(3.14);
        double d = nb2.getValue();
        nb2.getDoubleValue();
//        NumberBox<String> nb3 = new NumberBox<String>("a");

        SortedBox<Integer> b1 = new SortedBox<>(10);
        System.out.println(b1.isGreaterThan(15));

    }
}
