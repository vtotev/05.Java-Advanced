package Generics.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable> {
    private List<T> value;

    public CustomList() {
        this.value = new ArrayList<>();
    }

    public void add(T value) {
        this.value.add(value);
    }

    public T remove(int index) {
        return this.value.remove(index);
    }

    public boolean contains(T value) {
       return  this.value.contains(value);
    }

    public void swap(int index1, int index2) {
        Collections.swap(this.value, index1, index2);
    }

    public long getGreatherThan(T valueToCompare) {
        return this.value.stream().filter(e -> e.compareTo(valueToCompare) > 0).count();
    }

    public T getMax() {
        T maxEl = this.value.get(0);
        for (T el: this.value) {
            if (el.compareTo(maxEl) > 0) {
                maxEl = el;
            }
        }
        return maxEl;
    }

    public T getMin() {
        T minEl = this.value.get(0);
        for (T el: this.value) {
            if (el.compareTo(minEl) < 0) {
                minEl = el;
            }
        }
        return minEl;
    }

    public void print() {
        for (T item : value) {
            System.out.println(item.toString());
        }
    }
}
