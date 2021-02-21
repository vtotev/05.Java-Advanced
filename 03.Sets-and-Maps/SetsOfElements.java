package SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] sizes = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();
        Set<Integer> repeatingSet = new LinkedHashSet<>();
        for (int i = 0; i < sizes[0]; i++) {
            firstSet.add(Integer.parseInt(scan.nextLine()));
        }
        for (int i = 0; i < sizes[1]; i++) {
            secondSet.add(Integer.parseInt(scan.nextLine()));
        }
        for (Integer num : firstSet) {
            if (secondSet.contains(num)) {
                repeatingSet.add(num);
            }
        }
        repeatingSet.stream().forEach(s -> System.out.print(s + " "));
    }
}
