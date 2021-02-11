package SkacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long num = Integer.parseInt(scan.nextLine());
        ArrayDeque<Long> fibonacci = new ArrayDeque<>();
        fibonacci.push((long) 1);
        fibonacci.push((long) 1);
        if (num <= 1) {
            System.out.println(1);
            return;
        } else {
            for (int i = 1; i < num; i++) {
                long firstNum = fibonacci.pop();
                long secNum = fibonacci.pop();
                fibonacci.push(firstNum);
                fibonacci.push(firstNum+secNum);
            }
        }
        System.out.println(fibonacci.peek());
        //System.out.println(recursiveFibonacci(num));
    }

    private static long recursiveFibonacci(int n) {
        if (n <= 1) {
            return 1;
        }
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }
}
