package SkacksAndQueues;

import java.util.*;

public class Robotics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] robotsArr = scan.nextLine().split(";");
        String[] robots = new String[robotsArr.length];
        int[] processTime = new int[robotsArr.length];
        for (int i = 0; i < robotsArr.length; i++) {
            String[] robotsParams = robotsArr[i].split("-");
            robots[i] = robotsParams[0];
            processTime[i] = Integer.parseInt(robotsParams[1]);
        }

        int[] startingTime = Arrays.stream(scan.nextLine().split(":")).mapToInt(Integer::parseInt).toArray();
        long timeInSeconds = (startingTime[0]*3600)+(startingTime[1]*60)+startingTime[2];

        String input = scan.nextLine();
        ArrayDeque<String> items = new ArrayDeque<>();
        while (!input.equals("End")) {
            items.offer(input);
            input = scan.nextLine();
        }
        int[] robotsWorktime = new int[robots.length];
        while (!items.isEmpty()) {
            timeInSeconds++;
            String product = items.poll();
            int index = -1;

            for (int i = 0; i < robotsWorktime.length; i++) {
                if (robotsWorktime[i] > 0) {
                    robotsWorktime[i]--;
                }
                if (robotsWorktime[i] == 0 && index == -1) {
                    index = i;
                }
            }
            
            if (index != -1) {
                robotsWorktime[index] = processTime[index];
                System.out.println(printRobotData(robots[index], product, timeInSeconds));
            } else {
                items.offer(product);
            }
        }
    }

    private static String printRobotData(String robot, String product, long time) {
        String timeFormatted = String.format("%02d:%02d:%02d", (time/3600)%24, (time/60)%60, time%60);
        return String.format("%s - %s [%s]", robot, product, timeFormatted);
    }
}
