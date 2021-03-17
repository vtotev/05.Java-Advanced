package Generics.GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < count; i++) {
            Box<String> box = new Box<>(scan.nextLine());
            System.out.println(box.toString());
        }
    }
}
