package SkacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < count; i++) {
            String[] cmd = scan.nextLine().split("\\s+");
            switch (cmd[0]) {
                case "1":
                    String pushStr = "";
                    if (!stack.isEmpty()) {
                        pushStr = stack.peek();
                    }
                    pushStr += cmd[1];
                    stack.push(pushStr);
                    break;
                case "2":
                    if (!stack.isEmpty()) {
                        String currStr = stack.peek();
                        int idx = Integer.parseInt(cmd[1]);
                        if (idx >= currStr.length()) {
                            currStr = "";
                        } else {
                            currStr = currStr.substring(0, currStr.length() - idx);
                        }
                        stack.push(currStr);
                    }
                    break;
                case "3":
                    if (!stack.isEmpty()) {
                        String peekStr = stack.peek();
                        int peekIdx = Integer.parseInt(cmd[1])-1;
                        if (peekIdx >= 0 && peekIdx <= peekStr.length()) {
                            System.out.println(peekStr.charAt(peekIdx));
                        }
                    }
                    break;
                case "4":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
            }
        }
    }
}
