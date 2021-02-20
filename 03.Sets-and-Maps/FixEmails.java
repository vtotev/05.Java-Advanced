package SetsAndMapsAdvanced;

import java.util.*;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> mails = new LinkedHashMap<>();
        String name = scan.nextLine();
        while (!name.equalsIgnoreCase("stop")) {
            String mailAddress = scan.nextLine();
            mails.put(name, mailAddress);
            name = scan.nextLine();
        }
        List<String> domains = new ArrayList<>();
        domains.add(".uk");
        domains.add(".us");
        domains.add(".com");
        for (Map.Entry<String, String> entry : mails.entrySet()) {
            boolean doesContain = false;
            for (String dom : domains) {
                if (entry.getValue().contains(dom)) {
                    doesContain = true;
                    break;
                }
            }
            if (!doesContain) {
                System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
            }
        }
    }
}
