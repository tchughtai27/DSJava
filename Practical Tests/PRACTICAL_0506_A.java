public class PRACTICAL_0506_A {
    public static void swap(int a, int b, int[] numbers) {

        if (numbers == null || a < 0 || b < 0 || a >= numbers.length || b >= numbers.length) {
            return;
        }

        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }

    public static void main(String[] args) {
        int[] numbers = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println("Before swap: " + java.util.Arrays.toString(numbers));

        swap(2, 7, numbers); // Swap elements at index 1 and 3
        System.out.println("After swap: " + java.util.Arrays.toString(numbers));
    }
}
