package DefiningClasses.SpeedRacing;

public class Car {
    String model;
    double fuelAmount;
    double fuelCostPerKM;
    int distanceTravelled = 0;

    public Car(String model, double fuelAmount, double fuelCostPerKM) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKM = fuelCostPerKM;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount -= fuelAmount;
    }

    public double getFuelCostPerKM() {
        return fuelCostPerKM;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled += distanceTravelled;
    }
}
