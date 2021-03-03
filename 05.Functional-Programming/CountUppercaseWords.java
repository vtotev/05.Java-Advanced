package FunctionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        List<String> uppercaseWords = new ArrayList<>();
        Predicate<String> isUpperCase = x -> Character.isUpperCase(x.charAt(0));
        for (String word : input) {
            if (isUpperCase.test(word)) {
                uppercaseWords.add(word);
            }
        }
        System.out.println(uppercaseWords.size());
        uppercaseWords.stream().forEach(System.out::println);
    }
}
