package Generics.GenericBoxOfInteger;

public class BoxInt<T> {
    private T value;

    public BoxInt(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", value.getClass().getCanonicalName(), value);
    }
}
