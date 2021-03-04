package FunctionalProgramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static List<String> guests = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        guests = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
        Map<String, Predicate<String>> predicates = new HashMap<>();
        String input = scan.nextLine();
        while (!input.equalsIgnoreCase("print")) {
            String[] cmd = input.split(";");
            String predicateName = cmd[1] + cmd[2];
            switch (cmd[0]) {
                case "Add filter":
                    Predicate<String> predicate = getPredicate(cmd);
                    predicates.put(predicateName, predicate);
                    break;
                case "Remove filter":
                    predicates.remove(predicateName);
                    break;
            }
            input = scan.nextLine();
        }
        guests.stream().filter(guest -> {
            boolean isValid = true;
            for (Predicate<String> predicate : predicates.values()) {
                if (predicate.test(guest)) {
                    isValid = false;
                    break;
                }
            }
            return isValid;
        }).forEach(o -> System.out.print(o + " "));
    }

    public static Predicate<String> getPredicate(String[] input) {
        Predicate<String> predicate = null;
        if (input[1].equalsIgnoreCase("Starts with")) {
            predicate = name -> name.startsWith(input[2]);
        } else if (input[1].equalsIgnoreCase("Ends with")) {
            predicate = name -> name.endsWith(input[2]);
        } else if (input[1].equalsIgnoreCase("Length")) {

            predicate = name -> name.length() == Integer.parseInt(input[2]);
        } else if (input[1].equalsIgnoreCase("Contains")) {
            {
                predicate = name -> name.contains(input[2]);
            }
        }
        return predicate;
    }
}