package DefiningClasses.CarInfo;

public class Car {
    public String Brand;
    public String Model;
    public int Horsepower;

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public int getHorsepower() {
        return Horsepower;
    }

    public void setHorsepower(int horsepower) {
        Horsepower = horsepower;
    }

    public Car(String brand, String model, int horsepower) {
        Brand = brand;
        Model = model;
        Horsepower = horsepower;
    }

    public String getCarInfo() {
        return String.format("The car is: %s %s - %d HP.", getBrand(), getModel(), getHorsepower());
    }
}
