package SkacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> kids = new ArrayDeque<>();
        Collections.addAll(kids, scan.nextLine().split("\\s+"));
        int tossNumber = Integer.parseInt(scan.nextLine());
        while (kids.size() > 1) {
            for (int i = 1; i < tossNumber; i++) {
                kids.offer(kids.poll());
            }
            System.out.println("Removed "+kids.poll());
        }
        System.out.println("Last is "+kids.poll());
    }
}
