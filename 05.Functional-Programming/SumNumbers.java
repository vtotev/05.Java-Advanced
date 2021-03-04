package FunctionalProgramming;

import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(", ");

        System.out.printf("Count = %d%n", input.length);
        if (input.length < 2) {
            System.out.printf("Sum = %s%n", input[0]);
        } else {
            Function<String, Integer> parser = x -> Integer.parseInt(x);
            int sum = 0;
            for (String s : input) {
                sum += parser.apply(s);
            }
            System.out.printf("Sum = %d%n", sum);

        }
    }
}
