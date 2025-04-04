package model;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Reader extends Person {

    private Set<Book> books = new HashSet<>();


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

    public void barrowBook(Book book){
        if(book == null){
            throw new IllegalArgumentException("The book names that you are trying to barrow cannot be blank, " +
                    "please enter valid book name");
        }
       if(book.getStatus() != Status.AVAILABLE){
           throw new IllegalStateException("The book names that you are trying to barrow is not available") ;
       }
      if(!books.contains(book)){
          books.add(book);
          book.setStatus(Status.BORROWED);
          System.out.println(book.getName() + " has been added into the books list.");
          book.display();

      }

    }
    public void returnBook(Book book){
        if(book == null){
            throw new IllegalArgumentException("The book names that you are trying to return cannot be blank, " +
                    "please enter valid book name");
        }
        if(book.getStatus() != Status.BORROWED ){
            throw new IllegalStateException("The book that you are trying to return is not barrowed, " +
                    "please check your list again") ;
        }
        if(books.contains(book)){
            books.remove(book);
            book.setStatus(Status.AVAILABLE);
            System.out.println( "Book => " + book.getName() + " | has been removed from your books list!");
        } else {
            throw new IllegalArgumentException("The book that you are trying to barrow is already in the Books list");
        }

    }

    public void showBook(){
        System.out.println("Available books list as follows; ");
        for(Book book : books){
            book.display();
        }
    }



}
