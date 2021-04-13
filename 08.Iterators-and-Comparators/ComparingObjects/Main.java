package IteratorsAndComparators.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Person> persons = new ArrayList<>();
        String input = scan.nextLine();
        while (!input.equalsIgnoreCase("end")) {
            String[] data = input.split("\\s+");
            Person person = new Person (data[0], Integer.parseInt(data[1]), data[2]);
            persons.add(person);
            input = scan.nextLine();
        }
        int count = 0;
        int index = Integer.parseInt(scan.nextLine());
        for (Person person : persons) {
            if (persons.get(index-1).compareTo(person) == 0) {
                count++;
            }
        }
        if (count == 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d%n", count, persons.size()-count, persons.size());
        }
    }
}
