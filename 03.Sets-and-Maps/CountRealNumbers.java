package SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Double, Integer> numbers = new LinkedHashMap<>();
        double[] numbersArr = Arrays.stream(scan.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        for (double d: numbersArr) {
            if (numbers.containsKey(d)) {
                numbers.put(d, numbers.get(d)+1);
            } else {
                numbers.put(d, 1);
            }
        }
        numbers.entrySet().stream().forEach(o -> System.out.printf("%.1f -> %d%n", o.getKey(), o.getValue()));
    }
}
