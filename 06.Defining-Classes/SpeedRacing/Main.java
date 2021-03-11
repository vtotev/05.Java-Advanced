package DefiningClasses.SpeedRacing;

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
            Car car = new Car(input[0], Double.parseDouble(input[1]), Double.parseDouble(input[2]));
            carList.add(car);
        }

        String input = scan.nextLine();
        while (!input.equalsIgnoreCase("end")) {
            String[] cmd = input.split("\\s+");
            Car car = carList.get(getCarIndex(carList, cmd[1]));
            int distance = Integer.parseInt(cmd[2]);
            double consumption = distance * car.getFuelCostPerKM();
            if (car.getFuelAmount() >= consumption) {
                car.setDistanceTravelled(distance);
                car.setFuelAmount(consumption);
            } else {
                System.out.println("Insufficient fuel for the drive");
            }
            input = scan.nextLine();
        }
        carList.stream().forEach(o -> System.out.printf("%s %.2f %d%n", o.getModel(), o.getFuelAmount(), o.getDistanceTravelled()));
    }

    public static int getCarIndex(List<Car> cars, String model) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getModel().equalsIgnoreCase(model)) {
                return i;
            }
        }
        return -1;
    }
}
