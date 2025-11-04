package a.basic.practice2;

public class Practice4 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            //System.out.println(i);
            for (int j = 5; i <= j; j--) {
                System.out.print("-");
            }
            for (int j = 1; j <= 2*i-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
