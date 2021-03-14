package Generics.CustomListSorted;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CustomList<String> list = new CustomList<>();
        String input = scan.nextLine();
        while (!input.equalsIgnoreCase("end")) {
            String[] cmd = input.split("\\s+");
            switch (cmd[0]) {
                case "Add":
                    list.add(cmd[1]);
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(cmd[1]));
                    break;
                case "Contains":
                    System.out.println(list.contains(cmd[1]));
                    break;
                case "Swap":
                    list.swap(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
                    break;
                case "Greater":
                    System.out.println(list.getGreatherThan(cmd[1]));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Sort":
                    list.sort();
                    break;
                case "Print":
                    list.print();
                    break;
            }
            input = scan.nextLine();
        }
    }
}
