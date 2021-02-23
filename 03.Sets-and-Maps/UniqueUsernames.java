package SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> names = new LinkedHashSet<>();
        int count = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < count; i++) {
            names.add(scan.nextLine());
        }
        names.stream().forEach(System.out::println);
    }
}
