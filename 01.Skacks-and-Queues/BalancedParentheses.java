package SkacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        if (input.length()%2 != 0) {
            System.out.println("NO");
            return;
        }

        ArrayDeque<Character> openingBrackets = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            if ((input.charAt(i) == '{') || (input.charAt(i) == '[') || (input.charAt(i) == '(')) {
                openingBrackets.push(input.charAt(i));
            }
            if (input.charAt(i) == '}') {
                char opening = openingBrackets.pop();
                if (opening != '{') {
                    System.out.println("NO");
                    return;
                }
            }
            if (input.charAt(i) == ']') {
                char opening = openingBrackets.pop();
                if (opening != '[') {
                    System.out.println("NO");
                    return;
                }
            }
            if (input.charAt(i) == ')') {
                char opening = openingBrackets.pop();
                if (opening != '(') {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}
