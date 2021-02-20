package SkacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());
        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int[] cmd = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            switch (cmd[0]) {
                case 1:
                    numbersStack.push(cmd[1]);
                    break;
                case 2:
                    numbersStack.pop();
                    break;
                case 3:
                    System.out.println(checkMax(numbersStack));
                    break;
            }
        }
    }

    public static int checkMax(ArrayDeque<Integer> stack) {
        int maxItem = Integer.MIN_VALUE;
        for (Integer item : stack) {
            if (item > maxItem) {
                maxItem = item;
            }
        }
        return maxItem;
    }
}
