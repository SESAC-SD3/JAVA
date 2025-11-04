package a.basic.practice2;

public class Practice3 {
    public static void main(String[] args) {
        int star = 10;
        for (int i = star ; i >= 1; i--){
            //System.out.println(i);
            for (int j = 1 ; j <= i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
