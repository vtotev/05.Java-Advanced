package SkacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        ArrayDeque<String> urlHistory = new ArrayDeque<>();
        ArrayDeque<String> urlForwardHistory = new ArrayDeque<>();
        String current = "";
        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (urlHistory.isEmpty()) {
                    System.out.println("no previous URLs");
                    input = scan.nextLine();
                    continue;
                } else {
                    urlForwardHistory.addFirst(current);
                    current = urlHistory.pop();
                }
            } else if (input.equals("forward")) {
                if (urlForwardHistory.isEmpty()) {
                    System.out.println("no next URLs");
                    input = scan.nextLine();
                    continue;
                } else {
                    current = urlForwardHistory.poll();
                    urlHistory.push(current);
                }
            } else {
                if (!current.isEmpty()) {
                    urlHistory.push(current);
                }
                current = input;
                urlForwardHistory.clear();
            }
            System.out.println(current);
            input = scan.nextLine();
        }
    }
}
