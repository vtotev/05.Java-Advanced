package SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> contacts = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!input.equalsIgnoreCase("search")) {
            String[] data = input.split("-");
            contacts.put(data[0], data[1]);
            input = scan.nextLine();
        }
        input = scan.nextLine();
        while (!input.equalsIgnoreCase("stop")) {
            if (contacts.containsKey(input)) {
                System.out.printf("%s -> %s%n", input, contacts.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }
            input = scan.nextLine();
        }
    }
}
