package SkacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] commands = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> numsQueue = new ArrayDeque<>();
        for (int i = 0; i < commands[0]; i++) {
            numsQueue.offer(numbers[i]);
        }
        for (int i = 0; i < commands[1]; i++) {
            numsQueue.poll();
        }
        if (numsQueue.isEmpty()) {
            System.out.println(0);
            return;
        }
        int smallestNum = Integer.MAX_VALUE;
        for (Integer item : numsQueue) {
            if (item < smallestNum) {
                smallestNum = item;
            }
            if (item.equals(commands[2])) {
                System.out.println("true");
                return;
            }
        }
        System.out.println(smallestNum);
    }
}
