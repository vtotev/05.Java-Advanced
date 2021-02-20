package SkacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> printQueue = new ArrayDeque<>();
        String input = scan.nextLine();
        while (!input.equals("print")) {
            if (input.equals("cancel")) {
                if (printQueue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled "+printQueue.poll());
                }
            } else {
                printQueue.offer(input);
            }
            input = scan.nextLine();
        }
        for (String print : printQueue
             ) {
            System.out.println(print);
        }
    }
}
