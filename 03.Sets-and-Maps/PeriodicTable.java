package SetsAndMapsAdvanced;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        Set<String> elements = new TreeSet<>();
        for (int i = 0; i < count; i++) {
            String[] el = scan.nextLine().split("\\s+");
            for (String e : el) {
                elements.add(e);
            }
        }
        elements.stream().forEach(s -> System.out.print(s + " "));;
    }
}
