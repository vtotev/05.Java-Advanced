package Generics.Threeuple;

public class Threeuple <T, V, E> {
    private T firstVal;
    private V secondVal;
    private E thirdVal;

    public Threeuple(T firstVal, V secondVal, E thirdVal) {
        this.firstVal = firstVal;
        this.secondVal = secondVal;
        this.thirdVal = thirdVal;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", this.firstVal, this.secondVal, this.thirdVal);
    }
}
