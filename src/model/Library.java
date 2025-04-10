package model;

import model.book.Book;
import model.book.Journals;
import model.book.Magazines;
import model.book.StudyBooks;
import model.book.enums.Status;
import model.person.Author;
import model.person.Reader;

import java.util.*;

public class Library { ///
    private static Library instance;
    private Set<Book> books = new HashSet<>();
    private List<Reader> readers;

    Book[] initialBooks = {
            new Magazines("Sefiller", new Author("Victor Hugo")),
            new Magazines("Not Sefiller :)", new Author("Victor Hugo")),
            new Magazines("1984", new Author("George Orwell")),
            new Magazines("1983 :)", new Author("George Orwell")),
            new Magazines("Suç ve Ceza", new Author("Fyodor Dostoyevski")),
            new Magazines("İstanbul Hatırası", new Author("Ahmet Ümit")),
            new Magazines("Küçük Prens", new Author("Antoine de Saint-Exupéry")),

            new StudyBooks("Bir Çöküşün Öyküsü", new Author("Stefan Zweig")),
            new StudyBooks("Simyacı", new Author("Paulo Coelho")),
            new StudyBooks("Yüzyıllık Yalnızlık", new Author("Gabriel García Márquez")),
            new StudyBooks("Don Kişot", new Author("Miguel de Cervantes")),
            new StudyBooks("Savaş ve Barış", new Author("Lev Tolstoy")),

            new Journals("Bilim ve Teknoloji", new Author("Ahmet Yılmaz")),
            new Journals("Edebiyat Dünyası", new Author("Mehmet Aksoy")),
            new Journals("Sosyal Bilimler", new Author("Ayşe Kara")),
            new Journals("Sanat ve Kültür", new Author("Emine Çelik"))
    };

    private  Library() { // *******
        this.books = new HashSet<>();
        this.readers = new ArrayList<>();

        for (Book book : initialBooks){
            books.add(book);
        }
    }

    public Set<Book> getBooks() {
        return Collections.unmodifiableSet(books);
    }

    public static Library getInstance() {
        if(instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public List<Reader> getReaders() {
        return Collections.unmodifiableList(readers);
    }

    public void newBook(Book book){
        books.add(book);
        List<Book> initialBookList = new ArrayList<>(Arrays.asList(initialBooks)); // *****
        initialBookList.add(book);
        System.out.println("Eklenen kitap : " + book.getName() + " Kitabin yazari: " + book.getAuthor());

    }

    public void lendBook(Book book, Reader reader){
        if( !book.getStatus().equals(Status.BORROWED) && reader.borrowBook(book)){
            System.out.println(reader.getName() +" kisisi " + book.getName() + " isimli kitabi odunc aldi");
        } else {
            System.out.println(book.getName() + " isimli kitap odunc verilemez");
        }
    }
    public void takeBack(Book book, Reader reader){
        reader.returnBook(book);
        System.out.println(reader.getName() + " kisisi " + book.getName() + " kitabini geri verdi");
    }

    public void showBook(){
        for(Book book : books){
            System.out.println(book);
        }
    }






}
