package FunctionalProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        Map<String, Integer> names = new LinkedHashMap<>();
        for (int i = 0; i < count; i++) {
            String[] input = scan.nextLine().split(", ");
            names.put(input[0], Integer.parseInt(input[1]));
        }
        String condition = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        String format = scan.nextLine();

        Predicate<Integer> tester = createTester(condition, age);
        Consumer<Map.Entry<String, Integer>> printer = createPrinter(format);
        printFiltered(names, tester, printer);
    }

    private static void printFiltered(Map<String, Integer> names, Predicate<Integer> tester, Consumer<Map.Entry<String, Integer>> printer) {
        for (Map.Entry<String, Integer> entry : names.entrySet()) {
            if (tester.test(names.get(entry.getKey()))) {
                printer.accept(entry);
            }
        }
    }

    public static Consumer<Map.Entry<String, Integer>> createPrinter(String format) {
        Consumer<Map.Entry<String, Integer>> printer = null;
        switch (format) {
            case "name":
                printer = person -> System.out.printf("%s%n", person.getKey());
                break;
            case "age":
                printer = person -> System.out.printf("%d%n", person.getValue());
                break;
            case "name age":
                printer = person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());
                break;
        }
        return printer;
    }

    public static Predicate<Integer> createTester(String condition, int age) {
        Predicate<Integer> tester = null;
        switch (condition) {
            case "younger":
                tester = x -> x < age;
                break;
            case "older":
                tester = x -> x >= age;
                break;
        }
        return tester;
    }

}
