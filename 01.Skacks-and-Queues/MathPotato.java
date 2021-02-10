package SkacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> kids = new ArrayDeque<>();
        Collections.addAll(kids, scan.nextLine().split("\\s+"));
        int tossNumber = Integer.parseInt(scan.nextLine());
        int cycles = 1;
        while (kids.size() > 1) {
            for (int i = 1; i < tossNumber; i++) {
                kids.offer(kids.poll());
            }
            if (isPrime(cycles)) {
                System.out.println("Prime " + kids.peek());
            } else {
                System.out.println("Removed " + kids.poll());
            }
            cycles++;
        }
        System.out.println("Last is " + kids.poll());
    }

    public static boolean isPrime(int number) {
        if (number == 0 || number == 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
