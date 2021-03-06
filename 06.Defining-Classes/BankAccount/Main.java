package DefiningClasses.BankAccount;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Integer, BankAccount> accounts = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!input.equalsIgnoreCase("end")) {
            String[] cmd = input.split("\\s+");
            switch (cmd[0]) {
                case "Create":
                    BankAccount accNew = new BankAccount();
                    System.out.printf("Account ID%d created%n", accNew.getId());
                    accounts.put(accNew.getId(), accNew);
                    break;
                case "Deposit":
                    if (!accounts.containsKey(Integer.parseInt(cmd[1]))) {
                        System.out.println("Account does not exist");
                    } else {
                        accounts.get(Integer.parseInt(cmd[1])).deposit(Double.parseDouble(cmd[2]));
                        System.out.printf("Deposited %s to ID%d%n", cmd[2], Integer.parseInt(cmd[1]));
                    }
                    break;
                case "GetInterest":
                    if (!accounts.containsKey(Integer.parseInt(cmd[1]))) {
                        System.out.println("Account does not exist");
                    } else {
                        System.out.printf("%.2f%n", accounts.get(Integer.parseInt(cmd[1])).getInterest(Integer.parseInt(cmd[2])));
                    }
                    break;
                case "SetInterest":
                    BankAccount.setInterestRate(Double.parseDouble(cmd[1]));
                    break;

            }
            input = scan.nextLine();
        }
    }
}
