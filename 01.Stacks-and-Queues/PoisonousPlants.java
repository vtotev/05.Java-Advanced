package SkacksAndQueues;

import java.util.*;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        int[] plants = new int[count];
        for (int i = 0; i < count; i++) {
            plants[i] = Integer.parseInt(input[i]);
        }
        ArrayDeque<Integer> pesticides = new ArrayDeque<>();
        pesticides.push(0);
        int[] days = new int[count];
        for (int i = 1; i < count; i++) {
            int maxDays = 0;
            while (!pesticides.isEmpty() && plants[pesticides.peek()] >= plants[i]) {
                maxDays = Math.max(maxDays, days[pesticides.pop()]);
            }
            if (!pesticides.isEmpty()) {
                days[i] = maxDays + 1;
            }
            pesticides.push(i);
        }
        System.out.println(getDays(days));
    }

    private static int getDays(int[] days) {
        int lastDay = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > lastDay) {
                lastDay = days[i];
            }
        }
        return lastDay;
    }
}
