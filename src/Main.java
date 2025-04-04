import model.Author;
import model.Book;
import model.Person;
import model.Reader;

public class Main {
    public static void main(String[] args) {

        Person mustafa = new Reader("Mustafa");


        Book book1 = new Book("Java Programming", new Author("John Doe"), 7);
        Book book2 = new Book("Design Patterns", new Author("Ali Veli"), 5);

        System.out.println( book1.getStatus());
        Reader reader = (Reader) mustafa;
       reader.barrowBook(book1);


    }
}