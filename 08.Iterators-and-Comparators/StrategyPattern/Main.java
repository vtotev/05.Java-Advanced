package IteratorsAndComparators.StrategyPattern;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<Person> nameCompared = new TreeSet<>(new nameComparator());
        Set<Person> ageCompared = new TreeSet<>(new ageComparator());

        int count = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < count; i++) {
            String[] data = scan.nextLine().split("\\s+");
            Person person = new Person(data[0], Integer.parseInt(data[1]));
            nameCompared.add(person);
            ageCompared.add(person);
        }
        nameCompared.forEach(p -> System.out.println(p.toString()));
        ageCompared.forEach(p -> System.out.println(p.toString()));
    }
}
