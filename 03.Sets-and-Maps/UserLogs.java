package SetsAndMapsAdvanced;

import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Map<String, Integer>> log = new TreeMap<>();
        String input = scan.nextLine();
        while (!input.equalsIgnoreCase("end")) {
            Map<String, Integer> currLog = new LinkedHashMap<>();
            String[] params = input.split(" ");
            String ipAddress = params[0].replace("IP=", "");
            String user = params[2].replace("user=", "");
            if (log.containsKey(user)) {
                currLog = log.get(user);
                if (currLog.containsKey(ipAddress)) {
                    currLog.put(ipAddress, currLog.get(ipAddress) + 1);
                } else {
                    currLog.put(ipAddress, 1);
                }
            } else {
                currLog.put(ipAddress, 1);
            }
            log.put(user, currLog);
            input = scan.nextLine();
        }
        log.entrySet().stream().forEach(l -> {
            System.out.printf("%s: %n", l.getKey());
            List<String> values = new ArrayList<>();
            l.getValue().entrySet().forEach(v -> values.add(String.format("%s => %d", v.getKey(), v.getValue())));
            System.out.print(String.join(", ", values));
            System.out.println(".");
        });
    }
}
