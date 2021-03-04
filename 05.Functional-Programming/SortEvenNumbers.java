package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).filter(o -> o % 2 == 0).toArray();
        int[] sorted = Arrays.stream(numbers).filter(o -> o % 2 == 0).sorted().toArray();
        printArray(numbers);
        printArray(sorted);
    }

    private static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
