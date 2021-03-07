package DefiningClasses.CarSalesman;

public class Car {
    String model;
    Engine engine;
    int weight = -1;
    String color = "n/a";

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    @Override
    public String toString() {
        String weightToStr = "";
        if (getWeight() != -1)
            weightToStr = getWeight()+"";
        else weightToStr = "n/a";
        return String.format("%s:%n%s%nWeight: %s%nColor: %s", getModel(), getEngine().toString(),
                weightToStr, getColor());
    }
}

class Engine {
    String model;
    int power;
    int displacement = -1;
    String efficiency = "n/a";

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        String displacementAsStr = "n/a";
        if (getDisplacement() != -1) {
            displacementAsStr = getDisplacement()+"";
        }
        return String.format("%s:%nPower: %d%nDisplacement: %s%nEfficiency: %s", getModel(), getPower(), displacementAsStr, getEfficiency());
    }
}