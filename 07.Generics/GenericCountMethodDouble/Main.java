package Generics.GenericCountMethodDouble;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        Box<Double> box = new Box<>();
        for (int i = 0; i < count; i++) {
            box.add(Double.parseDouble(scan.nextLine()));
        }
        double valueToCompare = Double.parseDouble(scan.nextLine());
        System.out.println(box.getGreatherThan(valueToCompare));
    }
}
