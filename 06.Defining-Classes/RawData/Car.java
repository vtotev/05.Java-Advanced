package DefiningClasses.RawData;

import java.util.ArrayList;
import java.util.List;

public class Car {
    String model;
    int engineSpeed;
    int enginePower;
    int cargoWeight;
    String cargoType;
    List<Tyre> tyres = new ArrayList<>();

    public String getModel() {
        return model;
    }

    public int getEngineSpeed() {
        return engineSpeed;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public String getCargoType() {
        return cargoType;
    }

    public List<Tyre> getTyres() {
        return tyres;
    }

    public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType, List<Tyre> tyres) {
        this.model = model;
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
        this.tyres = tyres;
    }


}

class Tyre {
    int tyreAge;
    double tyrePressure;

    public int getTyreAge() {
        return tyreAge;
    }

    public double getTyrePressure() {
        return tyrePressure;
    }

    public Tyre(int tyreAge, double tyrePressure) {
        this.tyreAge = tyreAge;
        this.tyrePressure = tyrePressure;
    }
}
