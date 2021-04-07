package IteratorsAndComparators.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book {
    private String title;
    private int year;
    private List<String> authors = new ArrayList<>();

    public Book(String title, int year, String... authors) {
        this.title = title;
        this.year = year;
        this.authors.addAll(Arrays.asList(authors));
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
