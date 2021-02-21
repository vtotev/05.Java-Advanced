package SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //lidl, juice, 2.30
        Map<String, Map<String, Double>> shop = new TreeMap<>();
        String input = scan.nextLine();
        while (!input.equals("Revision")) {
            String[] params = input.split(",\\s+");
            if (!shop.containsKey(params[0])) {
                shop.put(params[0], new LinkedHashMap<>());
            }
            Map<String, Double> value = shop.get(params[0]);
            value.putIfAbsent(params[1], Double.parseDouble(params[2]));
            input = scan.nextLine();
        }
        shop.entrySet().stream().forEach(o -> {
            System.out.println(o.getKey()+"->");
            o.getValue().entrySet().forEach(pr -> System.out.printf("Product: %s, Price: %.1f%n", pr.getKey(), pr.getValue()));
        });
    }
}
