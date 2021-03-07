package DefiningClasses.CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int engCount = Integer.parseInt(scan.nextLine());
        List<Engine> engineList = new ArrayList<>();
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < engCount; i++) {
            String[] engInput = scan.nextLine().split("\\s+");
            Engine newEngine = new Engine(engInput[0], Integer.parseInt(engInput[1]));
            if (engInput.length == 3) {
                if (Character.isDigit(engInput[2].charAt(0))) {
                    newEngine.setDisplacement(Integer.parseInt(engInput[2]));
                } else {
                    newEngine.setEfficiency(engInput[2]);
                }
            }
            if (engInput.length == 4) {
                newEngine.setDisplacement(Integer.parseInt(engInput[2]));
                newEngine.setEfficiency(engInput[3]);
            }
            engineList.add(newEngine);
        }

        int carCount = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < carCount; i++) {
            String[] carInput = scan.nextLine().split("\\s+");
            int engIndex = -1;
            for (int j = 0; j < engineList.size(); j++) {
                if (engineList.get(j).getModel().equals(carInput[1])) {
                    engIndex = j;
                    break;
                }
            }

            Car newCar = new Car(carInput[0], engineList.get(engIndex));
            if (carInput.length == 3) {
                if (Character.isDigit(carInput[2].charAt(0))) {
                    newCar.setWeight(Integer.parseInt(carInput[2]));
                } else {
                    newCar.setColor(carInput[2]);
                }
            }
            if (carInput.length == 4) {
                newCar.setWeight(Integer.parseInt(carInput[2]));
                newCar.setColor(carInput[3]);
            }
            carList.add(newCar);
            System.out.println(newCar.toString());
        }
    }
}
