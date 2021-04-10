package IteratorsAndComparators.Collection;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ListyIterator list = new ListyIterator(Arrays.stream(scan.nextLine().split("\\s+")).skip(1).collect(Collectors.toList()));
        String input = scan.nextLine();
        while (!input.equalsIgnoreCase("end")) {
            String[] cmd = input.split("\\s+");
            switch (cmd[0]) {
                case "Move":
                    System.out.println(list.Move());
                    break;
                case "Print":
                    try {
                        list.print();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "PrintAll":
                    try {
                        list.printAll();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(list.hasNext());
                    break;
            }

            input = scan.nextLine();
        }
    }
}
