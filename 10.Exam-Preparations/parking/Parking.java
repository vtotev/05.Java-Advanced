package ExamPreparation.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        data = new ArrayList<>();
    }
    public void add(Car car) {
        if (data.size() < capacity) {
            data.add(car);
        }
    }
    public boolean remove(String manufacturer, String model) {
        return data.removeIf(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model));
    }
    public Car getLatestCar() {
        if (data.isEmpty()) {
            return null;
        }
        return data.stream().sorted((o1, o2) -> Integer.compare(o2.getYear(), o1.getYear())).findFirst().get();
    }
    public Car getCar(String manufacturer, String model) {
        return data.stream().filter(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model))
                .findFirst().get();
    }
    public int getCount() {
        return data.size();
    }
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are parked in %s:", type));
        for (Car car : data) {
            sb.append(System.lineSeparator());
            sb.append(car);
        }
        return sb.toString();
    }
}
