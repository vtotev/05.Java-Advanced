package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Function<int[], int[]> add = a -> Arrays.stream(a).map(num -> num += 1).toArray();
        Function<int[], int[]> multiply = a -> Arrays.stream(a).map(num -> num *= 2).toArray();
        Function<int[], int[]> subtract = a -> Arrays.stream(a).map(num -> num -= 1).toArray();
        Consumer<int[]> print = a -> Arrays.stream(a).forEach(o -> System.out.print(o + " "));
        String input = scan.nextLine();
        while (!input.equalsIgnoreCase("end")) {
            switch (input) {
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;
            }
            input = scan.nextLine();
        }
    }
}
