package DefiningClasses.RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[] input = scan.nextLine().split("\\s+");
            List<Tyre> carTyres = new ArrayList<>();
            for (int j = 5; j < input.length; j += 2) {
                Tyre carSingleTyre = new Tyre(Integer.parseInt(input[j + 1]), Double.parseDouble(input[j]));
                carTyres.add(carSingleTyre);
            }
            Car newCar = new Car(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]),
                    Integer.parseInt(input[3]), input[4], carTyres);
            carList.add(newCar);
        }
        String input = scan.nextLine();
        if (input.equalsIgnoreCase("fragile")) {
            for (int i = 0; i < carList.size(); i++) {
                for (int z = 0; z < carList.get(i).tyres.size(); z++) {
                    if (carList.get(i).tyres.get(z).tyrePressure < 1) {
                        System.out.println(carList.get(i).getModel());
                        break;
                    }
                }
            }
        }
        if (input.equalsIgnoreCase("flamable")) {
            for (int i = 0; i < carList.size(); i++) {
                if (carList.get(i).getEnginePower() > 250)
                    System.out.println(carList.get(i).getModel());
            }
        }
    }
}
