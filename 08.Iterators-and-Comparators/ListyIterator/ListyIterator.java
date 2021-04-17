package IteratorsAndComparators.ListyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListyIterator {
    private static int index = 0;
    List<String> collection = new ArrayList<>();
    
    public ListyIterator(List<String> collection) {
        this.collection = collection;
    }

    public boolean Move() {
        if (index < collection.size() - 1) {
            index++;
            return true;
        }
        return false;
    }

    public void isValidOp() {
        if (collection.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
    }
    public void print() {
        isValidOp();;
        System.out.println(collection.get(index));
    }
    public boolean hasNext() {
        if (index < collection.size() - 1) {
            return true;
        }
        return false;
    }

}
