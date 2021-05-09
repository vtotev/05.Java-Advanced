package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MagicBox2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> firstMagicBox = new ArrayDeque<>();
        for (int num : numbers) {
            firstMagicBox.offer(num);
        }

        numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> secondMagicBox = new ArrayDeque<>();
        for (int num : numbers) {
            secondMagicBox.push(num);
        }

        int claimedItems = 0;
        while (!firstMagicBox.isEmpty() && !secondMagicBox.isEmpty()) {
            int firstBox = firstMagicBox.poll();
            int secondBox = secondMagicBox.pop();
            int sumBoxes = firstBox + secondBox;
            if (sumBoxes % 2 == 0) {
                claimedItems += sumBoxes;
            } else {
                firstMagicBox.addFirst(firstBox);
                firstMagicBox.addLast(secondBox);
            }
        }
        if (secondMagicBox.isEmpty()) {
            System.out.println("Second magic box is empty.");
        } else {
            System.out.println("First magic box is empty.");
        }
        if (claimedItems < 90) {
            System.out.println("Poor prey... Value: " + claimedItems);
        } else {
            System.out.println("Wow, your prey was epic! Value: " + claimedItems);
        }

    }

}
