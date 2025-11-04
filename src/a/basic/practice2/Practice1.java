package a.basic.practice2;

public class Practice1 {
    public static void main(String[] args) {

        for (int i = 2; i <= 9; i++) {
            if (i == 5) {
                continue;
            }
            for (int j = 1; j <= 9; j++) {
                System.out.println(i + "X" + j + "=" + (i*j));
            }
        }
    }
}
