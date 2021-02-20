package SkacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        ArrayDeque<String> output = new ArrayDeque<>();
        ArrayDeque<String> operators = new ArrayDeque<>();
        for (int i = 0; i < input.length; i++) {
            if (Character.isDigit(input[i].charAt(0)) || Character.isLetter(input[i].charAt(0))) {
                output.offer(input[i]);
            } else {
                if (operators.isEmpty()) {
                    operators.offer(input[i]);
                } else {
                    String lastOper = operators.peek();
                    switch (input[i]) {
                        case "+":
                        case "-":
                            if (lastOper.equals("(")) {
                                operators.push(input[i]);
                            } else {
                                output.offer(operators.pop());
                                operators.push(input[i]);
                            }
                            break;

                        case "*":
                        case "/":
                            if (lastOper.equals("*") || lastOper.equals("/")) {
                                output.offer(operators.pop());
                                operators.push(input[i]);
                            } else {
                                operators.push(input[i]);
                            }
                            break;
                        case "(":
                            operators.push(input[i]);
                            break;
                        case ")":
                            while (!operators.peek().equals("(")) {
                                output.offer(operators.pop());
                            }
                            operators.pop();
                            break;

                    }
                }
            }
        }
        while (!output.isEmpty()) {
            System.out.print(output.poll()+" ");
        }
        while (!operators.isEmpty()) {
            System.out.print(operators.poll()+" ");
        }
    }
}
