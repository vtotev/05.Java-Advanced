package DefiningClasses.CarInfo;

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
            Car car = new Car(input[0], input[1], Integer.parseInt(input[2]));
            carList.add(car);
        }
        carList.stream().forEach(o -> System.out.println(o.getCarInfo()));
    }
}
