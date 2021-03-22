package Generics.GenericCountMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        Box<String> box = new Box<>();
        for (int i = 0; i < count; i++) {
            box.add(scan.nextLine());
        }
        String valueToCompare = scan.nextLine();
        System.out.println(box.getGreatherThan(valueToCompare));
    }
}
