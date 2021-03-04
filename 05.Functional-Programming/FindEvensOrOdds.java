package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] range = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Predicate<Integer> isEven = num -> num % 2 == 0;
        String command = scan.nextLine();
        printNumbers(range, isEven, command);
    }

    private static void printNumbers(int[] range, Predicate<Integer> isEven, String command) {
        switch (command) {
            case "even":
                for (int i = range[0]; i <= range[1]; i++) {
                    if (isEven.test(i)) {
                        System.out.printf("%d ", i);
                    }
                }
                break;
            case "odd":
                for (int i = range[0]; i <= range[1]; i++) {
                    if (!isEven.test(i)) {
                        System.out.printf("%d ", i);
                    }
                }
                break;
        }
    }
}
