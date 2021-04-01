package Generics.Threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] firstInput = scan.nextLine().split("\\s+");
        Threeuple<String, String, String> first = new Threeuple<>(String.format("%s %s", firstInput[0], firstInput[1]), firstInput[2], firstInput[3]);

        String[] secondInput = scan.nextLine().split("\\s+");
        Threeuple<String, Integer, Boolean> second = new Threeuple<>(secondInput[0], Integer.parseInt(secondInput[1]), secondInput[2].equals("drunk"));

        String[] thirdInput = scan.nextLine().split("\\s+");
        Threeuple<String, Double, String> third = new Threeuple<>(thirdInput[0], Double.parseDouble(thirdInput[1]), thirdInput[2]);

        System.out.println(first.toString());
        System.out.println(second.toString());
        System.out.println(third.toString());
    }
}
