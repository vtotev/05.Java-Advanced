package SetsAndMapsAdvanced;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // continents, countries and their cities
        Map<String, Map<String, List<String>>> cities = new LinkedHashMap<>();
        int count = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < count; i++) {
            String[] input = scan.nextLine().split("\\s+");
            if (!cities.containsKey(input[0])) {
                cities.put(input[0], new LinkedHashMap<>());
            }
            Map<String, List<String>> currCity = cities.get(input[0]);
            if (!currCity.containsKey(input[1])) {
                currCity.put(input[1], new ArrayList<>());
            }
            List<String> currList = currCity.get(input[1]);
            currList.add(input[2]);
            currCity.put(input[1], currList);
            cities.put(input[0], currCity);
        }
        cities.entrySet().stream().forEach(o -> {
            System.out.println(o.getKey()+":");
            o.getValue().entrySet().stream().forEach(g -> {
                System.out.println("  "+g.getKey() + " -> " + String.join(", ", g.getValue()));
            });
        });
    }
}
