package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = Integer.parseInt(scan.nextLine());
        String[] names = scan.nextLine().split("\\s+");
        Predicate<String> checkLength = x -> x.length() <= length;
        Arrays.stream(names).filter(checkLength).forEach(s -> System.out.println(s));
    }
}
