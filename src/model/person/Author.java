package model.person;

import model.book.Book;

import java.util.HashSet;
import java.util.Set;

public class Author extends Person {

    private Set<Book> books = new HashSet<>();
//    private Map<Book, String> books = new HashMap<>();

    public Author(String name) {
        super(name);
    }

    @Override
    public void whoYouAre(){
        System.out.println("Author" + getName());
    }

    public boolean newBook (Book book){
        if (book == null) {
            throw new IllegalArgumentException("Eklemek istenen kitap bos olamaz");
        }
        return books.add(book);

    }

    public void showBook (){
        System.out.println("All Books: ");
        for (Book book : books){
            book.display();
        }
    }

    @Override
    public String toString() {
        return "Author" + getName();
    }
}
