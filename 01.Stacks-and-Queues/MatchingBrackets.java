package SkacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        ArrayDeque<Integer> indexes = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                indexes.push(i);
            } else if (input.charAt(i) == ')') {
                System.out.println(input.substring(indexes.pop(), i+1));
            }
        }
    }
}
