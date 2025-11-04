package a.basic;

public class For {
    public static void main(String[] args) {
        for (int i = 0 ; i < 10 ; i++) {
            System.out.println(i);
        }

        System.out.println();

        for (int i = 10 ; i >= 1 ; i-- ) {
            System.out.println(i);
        }

        System.out.println();

        for (int i = 0 ; i < 10 ; i += 2) {
            System.out.println(i);
        }

        System.out.println();

        for (int i = 0, j = 10; i < j; i++, j-- ) {
            System.out.println(i);
            System.out.println(j);
        }

        // 구구단 2단
        int dan = 2;
        for (int i = 1; i<= 9; i++ ) {
            System.out.println(dan + "X" + i + " = " + (dan * i));
        }

        // 구구단 2단 부터 9단까지
        for (int i = 2; i <= 9; i++) {
            // System.out.println(i);
            for (int j = 1; j <= 9; j++) {
                System.out.println(i + "X" + j + " = " + (j * i));
            }
        }

        // while
        int i = 0;

        while (i < 10) {
            System.out.println(i);
            i++;
        }

        // do-while
        int j = 100;

        do {
            System.out.println(j);
            j++;
        } while (j <= 10);


        // enhanced for
        // let numbers = [10, 11, 12, 13]
        int[] numbers = {10, 11, 12, 13, 14, 15, 16, 17, 18};
        for (i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        // for (const number of numbers) {}
        for (int number : numbers) {
            System.out.println(number);
        }


        int[] nums = {1, 2, 3};
        for (int num : nums) {
            // int num = 1
            num = num * 3;
        }

        for (int num : nums) {
            System.out.println(num);
        }

        for (int a = 0; a < nums.length ; a++) {
            nums[a] = nums[a] * 3;
        }

        for (int num : nums) {
            System.out.println(num);
        }


        // break
        for (int z = 0; z < 10; z++) {
            System.out.println(z);
            if (z == 5) {
                break;
            }
        }

        // continue
        for (int z = 0; z < 10; z++) {
            if (z % 2 == 0) {
                continue;
            }
            System.out.println(z);
        }

        outer:
        for (int x = 2; x < 10; x++) {
            for (int y = 1; y < 10; y++) {
                System.out.println(x + "X" + y + " = " + (x * y));
                if (x > 4) {
                    break outer;
                }
            }
        }
    }
}
