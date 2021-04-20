package IteratorsAndComparators.StrategyPattern;

import java.util.Comparator;

public class nameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int res = o1.getName().length() - o2.getName().length();
        if (res == 0) {
            char firstChar = o1.getName().toLowerCase().charAt(0);
            char secChar = o2.getName().toLowerCase().charAt(0);
            res = firstChar - secChar;
        }
        return res;
    }
}
