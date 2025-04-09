package model.person;

import model.book.Book;
import model.book.enums.Status;

import java.util.HashSet;
import java.util.Set;

public class Reader extends Person {

    private Set<Book> readerBooks = new HashSet<>();


    public Reader(String name) {
        super(name);
    }

    @Override
    public void whoYouAre() {
        System.out.println("Reader is " + getName());
    }

//    public void purchaseBook(Book book){
//        if(book == null){
//            throw new IllegalArgumentException("The book names that you are trying to purchase cannot be blank, " +
//                    "please enter valid book name");
//        }
//        if(books.contains(book)){
//            books.remove(book);
//        } else {
//            throw new IllegalArgumentException("The book that you are trying to purchase is not in the Books list");
//        }
//
//
//    }

    public boolean borrowBook(Book book){

           if (!readerBooks.contains(book)) {
               readerBooks.add(book);
               book.setStatus(Status.BORROWED);
               return true;
           }

       return false;
    }
    public boolean returnBook(Book book){

            if (readerBooks.contains(book)) {
                readerBooks.remove(book);
                book.setStatus(Status.AVAILABLE);
                System.out.println(book.getName() + " | has been removed from your books list!");
                showBook();
                return true;
            }
        return false;
    }

    public void showBook(){
        System.out.println("The books that you have as follows; ");
        for(Book book : readerBooks){
            book.display();
        }
    }



}
