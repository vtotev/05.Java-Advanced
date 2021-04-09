package IteratorsAndComparators.BookComparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book f, Book s) {
        if (f.getTitle().compareTo(s.getTitle()) == 0) {
            if (f.getYear() > s.getYear()) {
                return 1;
            } else if (f.getYear() < s.getYear()) {
                return -1;
            }
            return 0;
        } else {
            return f.getTitle().compareTo(s.getTitle());
        }

    }
//        int result = f.getTitle().compareTo(s.getTitle());
//        return result != 0
//                ? result
//                : Integer.compare(f.getYear(), s.getYear());
//    }
}
