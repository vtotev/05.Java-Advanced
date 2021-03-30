package Generics.ListUtilities;

import java.util.List;

public class ListUtils <T extends Comparable> {
    private List<T> items;

    public ListUtils(List<T> items) {
        this.items = items;
    }

    public static <T extends Comparable> T getMax(List<T> list) {
        ensureIsEmpty(list.isEmpty());
        T max = list.get(0);
        for (T item: list) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }
    public static <T extends Comparable> T getMin(List<T> list) {
        ensureIsEmpty(list.isEmpty());
        T min = list.get(0);
        for (T item: list) {
            if (item.compareTo(min) < 0) {
                min = item;
            }
        }
        return min;
    }
    private static void ensureIsEmpty(boolean isEmpty) {
        if (isEmpty) {
            throw new IllegalArgumentException();
        }
    }
}
