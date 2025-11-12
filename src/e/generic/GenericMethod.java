package e.generic;

public class GenericMethod {
    public static <T> void printArray(T[] array) {
        for (T item : array) {
            System.out.print(item);
        }
    }

    public static <T> void swap(T[] array, int i , int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        printArray(intArray);

        String[] stringArray = {"A", "B", "C"};
        printArray(stringArray);

        swap(intArray, 1, 2);
        printArray(intArray);

        swap(stringArray, 0, 2);
        printArray(stringArray);

    }
}
