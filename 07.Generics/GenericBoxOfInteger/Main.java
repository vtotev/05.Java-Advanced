package Generics.GenericBoxOfInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < count; i++) {
            BoxInt<Integer> box = new BoxInt<>(Integer.parseInt(scan.nextLine()));
            System.out.println(box.toString());
        }

    }
}
