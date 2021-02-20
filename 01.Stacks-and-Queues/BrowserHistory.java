package SkacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        ArrayDeque<String> urlHistory = new ArrayDeque<>();
        String current = "";
        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (urlHistory.isEmpty()) {
                    System.out.println("no previous URLs");
                    input = scan.nextLine();
                    continue;
                } else {
                    current = urlHistory.pop();
                }
            } else {
                if (!current.isEmpty()) {
                    urlHistory.push(current);
                }
                current = input;
            }
            System.out.println(current);
            input = scan.nextLine();
        }
    }
}
