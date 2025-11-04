package a.basic.practice2;

public class Practice2 {
    public static void main(String[] args) {
        for (int out = 1; out <= 5; out++) {
            //System.out.println(i + "*");
            for (int in = 1; in <= out; in++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
