package com.hongkailiu.test.app.cucumber;

import java.util.*;

/**
 * Created by ehongka on 4/14/15.
 */
public class Library {

    private final List<Book> store = new ArrayList<Book>();

    public void addBook(final Book book) {
        store.add(book);
    }

    public List<Book> findBooks(final Date from, final Date to) {
        Calendar end = Calendar.getInstance();
        end.setTime(to);
        end.roll(Calendar.YEAR, 1);

        List<Book> books = new ArrayList<Book>();
        for (Book b : store) {
            if (from.before(b.getPublished()) && end.getTime().after(b.getPublished())) {
                books.add(b);
            }
        }
        Collections.sort(books, Comparator.comparing(Book::getPublished).reversed());
        return books;
//        return store.stream().filter(book -> {
//            return from.before(book.getPublished()) && end.getTime().after(book.getPublished());
//        }).sorted(Comparator.comparing(Book::getPublished).reversed()).collect(Collectors.toList());
    }
}
