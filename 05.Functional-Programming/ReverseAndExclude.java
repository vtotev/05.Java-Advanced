package FunctionalProgramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int divNum = Integer.parseInt(scan.nextLine());
        Collections.reverse(numbers);
        Predicate<Integer> divisibleNums = n -> n % divNum!= 0;
        numbers.stream().filter(divisibleNums).forEach(n -> System.out.print(n+" "));
    }
}
