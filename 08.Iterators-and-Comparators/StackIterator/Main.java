package IteratorsAndComparators.StackIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CustomStack stack = new CustomStack();
        String[] initialValues = scan.nextLine().split(",\\s+");
        stack.push(Integer.parseInt(initialValues[0].split("\\s+")[1]));
        for (int i = 1; i < initialValues.length; i++) {
            stack.push(Integer.parseInt(initialValues[i].trim()));
        }
        String input = scan.nextLine();
        while (!input.equalsIgnoreCase("end")) {
            if (input.equals("Pop")) {
                try {
                    stack.pop();
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                stack.push(Integer.parseInt(input.split("\\s+")[1]));
            }

            input = scan.nextLine();
        }
        for (int i = 0; i < 2; i++) {
            for (Integer item : stack) {
                System.out.println(item);
            }
        }
    }
}
