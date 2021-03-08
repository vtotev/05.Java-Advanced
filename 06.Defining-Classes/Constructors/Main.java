package DefiningClasses.Constructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Car> carList = new ArrayList<>();
        int count = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < count; i++) {
            String[] input = scan.nextLine().split("\\s+");
            Car car;
            if (input.length == 1) {
                car = new Car(input[0]);
            } else {
                car = new Car(input[0], input[1], Integer.parseInt(input[2]));
            }
            carList.add(car);
        }
        carList.stream().forEach(o -> System.out.println(o.getCarInfo()));
    }
}
