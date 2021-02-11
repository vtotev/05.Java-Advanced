package SkacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String[] input = scan.nextLine().split("\\s+");
        stack.push(Integer.parseInt(input[0]));
        for (int i = 1; i < input.length; i++) {
            int leftOp = stack.pop();
            String operation = input[i];
            int rightOp = Integer.parseInt(input[++i]);
            int result = operation.equals("+")
                    ? leftOp + rightOp
                    : leftOp - rightOp;
            stack.push(result);
        }
        System.out.println(stack.pop());
    }
}
