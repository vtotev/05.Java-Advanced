package SkacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        if (number == 0) {
            System.out.println("0");
            return;
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        while (number != 0) {
            stack.push(number % 2);
            number /= 2;
        }
        for (Integer stackItem : stack
             ) {
            System.out.print(stackItem);
        }
    }
}
