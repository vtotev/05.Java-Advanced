package SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> resources = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!input.equalsIgnoreCase("stop")) {
            int quantity = Integer.parseInt(scan.nextLine());
            if (!resources.containsKey(input)) {
                resources.put(input, quantity);
            } else {
                resources.put(input, resources.get(input)+quantity);
            }
            input = scan.nextLine();
        }
        resources.entrySet().forEach(s -> System.out.printf("%s -> %d%n", s.getKey(), s.getValue()));
    }
}
