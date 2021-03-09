package DefiningClasses.OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[] input = scan.nextLine().split("\\s+");
            Person person = new Person(input[0], Integer.parseInt(input[1]));
            personList.add(person);
        }
        personList.stream().filter(o -> o.getAge() > 30).sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
                .forEach(o -> System.out.printf("%s - %d%n", o.getName(), o.getAge()));
    }
}
