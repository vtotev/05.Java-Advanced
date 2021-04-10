package IteratorsAndComparators.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListyIterator implements Iterable<String> {
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


    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index;
            @Override
            public boolean hasNext() {
                return index < collection.size();
            }

            @Override
            public String next() {
                return collection.get(index++);
            }
        };
    }

    @Override
    public void forEach(Consumer<? super String> action) {
        for (int i = 0; i < this.collection.size(); i++) {
            action.accept(this.collection.get(i));
        }
    }

    public void printAll() {
        isValidOp();
        collection.forEach(s -> System.out.print(s + " "));
        System.out.println();
    }

}
