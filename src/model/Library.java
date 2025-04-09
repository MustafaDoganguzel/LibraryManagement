package model;

import model.book.Book;
import model.person.Reader;

import java.util.HashSet;
import java.util.Set;

public class Library {
    public static final String NAME = "MBP Library";
    private Set<Book> books = new HashSet<>();
    private Reader readers;

    public Library() {

    }

    public Set<Book> getBooks() {
        return books;
    }

    public Reader getReaders() {
        return readers;
    }

    public void newBook(Book book){
        if(book == null) throw new IllegalArgumentException("The book trying to add, cannot be blank. " +
                "Please add valid informations");
        books.add(book);
    }



}
