package SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> guests = new LinkedHashSet<>();
        String input = scan.nextLine();
        while (!input.equals("PARTY")) {
            guests.add(input);
            input = scan.nextLine();
        }
        input = scan.nextLine();
        while (!input.equals("END")) {
            guests.remove(input);
            input = scan.nextLine();
        }
        System.out.println(guests.size());
        guests.stream().sorted().forEach(o -> System.out.println(o));
    }
}
