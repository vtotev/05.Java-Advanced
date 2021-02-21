package SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> cars = new LinkedHashSet<>();
        String input = scan.nextLine();
        while (!input.equals("END")) {
            String[] cmd = input.split(",\\s+");
            switch (cmd[0]) {
                case "IN":
                    cars.add(cmd[1]);
                    break;
                case "OUT":
                    cars.remove(cmd[1]);
                    break;
            }
            input = scan.nextLine();
        }
        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            cars.stream().forEach(o -> System.out.println(o));
        }
    }
}
