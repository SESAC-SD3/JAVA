package g.javaclass;

import java.util.Arrays;

public class StringMain {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        System.out.println(str1 == str2);

        String str3 = "hello";
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str3));

        System.out.println(str1.length());
        System.out.println(str1.charAt(2));
        System.out.println(str1.indexOf("z"));
        System.out.println(str1.lastIndexOf("l"));

        System.out.println(str1.substring(2, 4));
        System.out.println(str1);

        System.out.println(str1.contains("H"));
        System.out.println(str1.startsWith("h"));

        System.out.println(str1.isEmpty());

        String str4 = "      Hello    \n";
        System.out.println(str4.trim());

        str4.replace("Hello", "Hi");
        System.out.println(str4);

        String csv = "apple, banana, orange";
        String[] fruits = csv.split(", ");
        System.out.println(Arrays.toString(fruits));

        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(5);
        sb.append(10);
        System.out.println(sb.toString());






    }
}
