package model.book;

import model.book.enums.Status;
import model.person.Author;
import model.person.Person;

import java.time.LocalDate;
import java.util.Objects;

public class Book {
    private static int bookIdCounter = 1;
    private int bookId;
    private Author author;
    private String name;
    private int price;
    private Status status;
    private Person owner;
    private LocalDate dateOfPurchase;

    public Book( String name, Author author,  int price){
        this.bookId = bookIdCounter++;
        this.name = name;
        this.author = author;
        this.price = price;
        this.status = Status.AVAILABLE;
        this.dateOfPurchase = LocalDate.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookId, book.bookId) && Objects.equals(author, book.author) && Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, author, name);
    }

    public void display(){
        System.out.println( "Book id :" + bookId
                + " | Book Name: " +getName()
        + " | Author: " +getAuthor()
        + " | Price: " + getPrice()
        + " | Date of Purchase " + getDateOfPurchase());

    }

    public int getBookId() {
        return bookId;
    }

    public Author getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status newStatus) {
        try {
            if (newStatus == null) {
                throw new IllegalArgumentException("Please enter valid status");
            }
            if (status == newStatus) {
                throw new IllegalArgumentException("Status is same!");
            }
            this.status = newStatus;
        } catch (IllegalArgumentException e) {
            System.out.println("Hata: " + e.getMessage());
        }


    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", author= " + author +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", owner=" + owner +
                ", dateOfPurchase=" + dateOfPurchase +
                '}';
    }
}
