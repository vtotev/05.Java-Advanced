package SetsAndMapsAdvanced;

import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        Map<String, Map<String, Integer>> userLogs = new TreeMap<>();
        for (int i = 0; i < count; i++) {
            String input[] = scan.nextLine().split(" ");
            String ipAddress = input[0];
            String user = input[1];
            int duration = Integer.parseInt(input[2]);
            Map<String, Integer> currLog = new TreeMap<>();
            if (userLogs.containsKey(user)) {
                currLog = userLogs.get(user);
            }
            if (currLog.containsKey(ipAddress)) {
                currLog.put(ipAddress, currLog.get(ipAddress)+duration);
            } else {
                currLog.put(ipAddress, duration);
            }
            userLogs.put(user, currLog);
        }
        userLogs.entrySet().stream().forEach(o -> {
            int sum = 0;
            List<String> addresses = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : o.getValue().entrySet()) {
                sum += entry.getValue();
                addresses.add(entry.getKey());
            }
            System.out.printf("%s: %d [%s]%n", o.getKey(), sum, String.join(", ", addresses));
        });
    }
}
