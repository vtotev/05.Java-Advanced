package Exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> firstBox = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondBox = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(secondBox::push);

        int claimedItems = 0;
        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int first = firstBox.poll();
            int second = secondBox.pop();
            int sum = first+ second;
            if (sum % 2 == 0) {
                claimedItems += sum;
            } else {
                firstBox.addFirst(first);
                firstBox.addLast(second);
            }
        }
        if (firstBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }
        if (claimedItems >= 90) {
            System.out.println("Wow, your prey was epic! Value: " + claimedItems);
        } else {
            System.out.println("Poor prey... Value: " + claimedItems);
        }

    }
}
