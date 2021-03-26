package Generics.GenericSwapMethodInteger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoxSwap <T>{
    private List<T> value;

    public BoxSwap() {
        this.value = new ArrayList<>();
    }

    public void add(T value) {
        this.value.add(value);
    }

    public void swap(int index1, int index2) {
        Collections.swap(this.value, index1, index2);
    }

    public void print() {
        for (T item : value) {
            System.out.println(String.format("%s: %s", item.getClass().getCanonicalName(), item.toString()));
        }
    }
}
