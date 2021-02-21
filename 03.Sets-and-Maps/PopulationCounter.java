package SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Map<String, Long>> countries = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!input.equalsIgnoreCase("report")) {
            String[] data = input.split("\\|");
            String city = data[0];
            String country = data[1];
            long population = Long.parseLong(data[2]);
            Map<String, Long> cityMap = new LinkedHashMap<>();
            if (countries.containsKey(country)) {
                cityMap = countries.get(country);
            }
            if (cityMap.containsKey(city)) {
                cityMap.put(city, cityMap.get(city)+population);
            } else {
                cityMap.put(city, population);
            }
            countries.put(country, cityMap);
            input = scan.nextLine();
        }
        countries.entrySet().stream().sorted((o1, o2) -> {
            long sum1 = 0;
            long sum2 = 0;
            for (Map.Entry<String, Long> entry: o2.getValue().entrySet()) {
                sum2 += entry.getValue();
            }
            for (Map.Entry<String, Long> entry: o1.getValue().entrySet()) {
                sum1 += entry.getValue();
            }
            return Long.compare(sum2, sum1);
        }).forEach(o -> {
            long sum = 0;
            for (Map.Entry<String, Long> entry: o.getValue().entrySet()) {
                sum += entry.getValue();
            }
            System.out.printf("%s (total population: %d)%n", o.getKey(), sum);
            o.getValue().entrySet().stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue())).forEach(c -> System.out.printf("=>%s: %d%n", c.getKey(), c.getValue()));
        });
    }
}
