package FunctionalProgramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates {

//        Find all numbers in the range 1..N that are divisible by the numbers of a given sequence. Use predicates.
//        Examples
//        Input	        Output
//        10
//        1 1 1 2	    2 4 6 8 10

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int range = Integer.parseInt(scan.nextLine());
        Set<Integer> divisibleNums = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(HashSet::new));
        Predicate<Integer> divisibleBy = num -> {
            for (Integer divider: divisibleNums) {
                if (num % divider != 0)
                    return false;
            }
            return true;
        };
        for (int i = 1; i <= range; i++) {
            if (divisibleBy.test(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
