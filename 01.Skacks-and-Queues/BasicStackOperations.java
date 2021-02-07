package SkacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] commands = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> output = new ArrayDeque<>();
        for (int i = 0; i < commands[0]; i++) {
            output.push(numbers[i]);
        }
        for (int i = 0; i < commands[1]; i++) {
            output.pop();
        }
        int smallestNum = Integer.MAX_VALUE;
        for (Integer item : output
        ) {
            if (item < smallestNum) {
                smallestNum = item;
            }
            if (item.equals(commands[2])) {
                System.out.println("true");
                return;
            }
        }
        if (smallestNum == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(smallestNum);
        }
    }
}
