package SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrybskoUnleashed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regex = "(?<name>\\w+\\s*\\w*\\s*\\w*)(\\s@)(?<city>\\w+\\s*\\w*\\s*\\w*)(\\s+)(?<price>(\\d+))\\4(?<count>\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Map<String, Map<String, Long>> tourData = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!input.equalsIgnoreCase("End")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String singer = matcher.group("name");
                String city = matcher.group("city");
                long price = Long.parseLong(matcher.group("price"));
                long ticketsCount = Long.parseLong(matcher.group("count"));

                Map<String, Long> citySingers = new LinkedHashMap<>();
                if (tourData.containsKey(city)) {
                    citySingers = tourData.get(city);
                }
                long profit = price * ticketsCount;
                if (citySingers.containsKey(singer)) {
                    citySingers.put(singer, citySingers.get(singer)+profit);
                } else {
                    citySingers.put(singer, profit);
                }
                tourData.put(city, citySingers);
            }
            input = scan.nextLine();
        }
        tourData.entrySet().stream().forEach(o -> {
            System.out.println(o.getKey());
            o.getValue().entrySet().stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                    .forEach(s -> System.out.printf("#  %s -> %d%n", s.getKey(), s.getValue()));
        });
    }
}
