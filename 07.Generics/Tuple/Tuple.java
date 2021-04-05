package Generics.Tuple;

public class Tuple <T, V> {
    private T firstVal;
    private V secondVal;

    public Tuple(T firstVal, V secondVal) {
        this.firstVal = firstVal;
        this.secondVal = secondVal;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", this.firstVal, this.secondVal);
    }
}
