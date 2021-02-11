package SkacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (Integer num : numbers) {
            numbersStack.push(num);
        }
        while (!numbersStack.isEmpty()) {
            System.out.print(numbersStack.pop()+" ");
        }
    }
}
