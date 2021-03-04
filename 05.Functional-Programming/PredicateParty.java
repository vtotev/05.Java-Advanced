package FunctionalProgramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    static List<String> guests = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        guests = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
        String input = scan.nextLine();
        while (!input.equalsIgnoreCase("party!")) {
            String[] cmd = input.split("\\s+");
            switch (cmd[0]) {
                case "Double":
                    AddOneMore(getPredicate(cmd));
                    break;
                case "Remove":
                    RemoveGuest(getPredicate(cmd));
                    break;
            }
            input = scan.nextLine();
        }
        if (!guests.isEmpty()) {
            Collections.sort(guests);
            System.out.println(String.join(", ", guests)+" are going to the party!");
        } else {
            System.out.println("Nobody is going to the party!");
        }
    }

    private static void RemoveGuest(Predicate<String> predicate) {
        List<String> namesToRem = new ArrayList<>();
        guests.stream().filter(predicate).forEach(namesToRem::add);
        guests.removeAll(namesToRem);
    }

    private static void AddOneMore(Predicate<String> predicate) {
        List<String> namesToAdd = new ArrayList<>();
        guests.stream().filter(predicate).forEach(namesToAdd::add);
        guests.addAll(namesToAdd);
    }

    public static Predicate<String> getPredicate(String[] input) {
        Predicate<String> predicate = null;
        if (input[1].equalsIgnoreCase("StartsWith")) {
            predicate = name -> name.startsWith(input[2]);
        } else if (input[1].equalsIgnoreCase("EndsWith")) {
            predicate = name -> name.endsWith(input[2]);
        } else {
            predicate = name -> name.length() == Integer.parseInt(input[2]);
        }
        return predicate;
    }
}
