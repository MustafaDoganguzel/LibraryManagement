import model.Library;
import model.book.Book;
import model.book.Journals;
import model.book.Magazines;
import model.book.StudyBooks;
import model.person.Author;
import model.person.Reader;

import java.util.Scanner;

public class Main {

//    static Map<String, String> userDatabase = new HashMap<>();
//    static Map<String, Person> userObjects = new HashMap<>();
    private static Library library = Library.getInstance();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean working = true;

        while (working){
            showMenu();
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    library.showBook();
                    break;
                case "2":
                    System.out.println("Eklemek Istediginiz kitabin adini ve Yazarinin adini yaziniz");
                    String book = sc.nextLine();
                    String[] promptBook = book.trim().toLowerCase().split(" ");
                    Book promptedBook = new Book(promptBook[0], new Author(promptBook[1]));
                    library.newBook(promptedBook);
                    break;
                case "3":
                    System.out.println("Aradiginiz kitabin ismini belirtiniz");
                    String bookName = sc.nextLine().trim().toLowerCase();

                    boolean found = false;
                    for (Book bn : library.getBooks()) {
                        if (bn.getName().toLowerCase().contains(bookName)) {
                            System.out.println("Bulunan kitap: " + bn.getName() + " - " + " Yazarin Adi: " + bn.getAuthor());
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Aradiginiz kitap bulunamadi.");
                    }
                    break;

                case "4":
                    System.out.println("Istenilen Kategoriyi giriniz");
                    System.out.println("1- Magazines");
                    System.out.println("2- Study Books");
                    System.out.println("3- Journals");
                    String category = sc.nextLine();

                    switch (category) {
                        case "1":
                            System.out.println("Magazines Kategorisindeki Kitaplar:");
                            for (Book book2 : library.getBooks()) {
                                if (book2 instanceof Magazines) {
                                    System.out.println(book2.getName() + " - " + book2.getAuthor());
                                }
                            }
                            break;

                        case "2": // Study Books kategorisini listeleme
                            System.out.println("Study Books Kategorisindeki Kitaplar:");
                            for (Book book2 : library.getBooks()) {
                                if (book2 instanceof StudyBooks) {
                                    System.out.println(book2.getName() + " - " + book2.getAuthor());
                                }
                            }
                            break;

                        case "3":
                            System.out.println("Journals Kategorisindeki Kitaplar:");
                            for (Book book2 : library.getBooks()) {
                                if (book2 instanceof Journals) {
                                    System.out.println(book2.getName() + " - " + book2.getAuthor());
                                }
                            }
                            break;

                        default:
                            System.out.println("Gecersiz kategori.");
                            break;
                    } break;

                case "5":
                    System.out.println("Yazarin Ismini giriniz");
                    String author = sc.nextLine();
                    boolean found1 = false;
                    for (Book b1: library.getBooks()){
                        if (b1.getAuthor().getName().toLowerCase().contains(author)){
                            System.out.println("Kitabinin ismi: " +b1.getName());
                            found1 =true;
                        }
                    }
                    if(!found1){
                        System.out.println("Yazara ait kitap bulunamadi");
                    } break;
                case "6":
                    System.out.println("Odunc alinacak kitabin adi ve yazarinin adi: ");
                    String borrow = sc.nextLine().trim().toLowerCase();

                    String[] bb = borrow.split(" ", 2);
                    String bookname = bb[0];
                    String authorName = bb[1];

                    Book borrowedB = null;

                    for (Book borrowBook : library.getBooks()) {
                        if (borrowBook.getName().toLowerCase().equals(bookname) &&
                                borrowBook.getAuthor().getName().toLowerCase().equals(authorName)) {
                            borrowedB = borrowBook;
                            break;
                        }
                    }
                    if (borrowedB != null) {
                        System.out.println("Kitabi alan kisinin adi: ");
                        String person = sc.nextLine();
                        Reader reader = new Reader(person);
                        library.lendBook(borrowedB, reader);
                    } else {
                        System.out.println("Kitap bulunamadi.");
                    }
                case "7":
                    System.out.println("Odunc alinan kitabin adi ve yazarinin adi: ");
                    String returnBookInput = sc.nextLine().trim().toLowerCase();

                    String[] bbReturn = returnBookInput.split(" ", 2);
                    String returnBookName = bbReturn[0];
                    String returnAuthorName = bbReturn[1];

                    Book returnedBook = null;

                    for (Book book1 : library.getBooks()) {
                        if (book1.getName().toLowerCase().equals(returnBookName) &&
                                book1.getAuthor().getName().toLowerCase().equals(returnAuthorName)) {
                            returnedBook = book1;
                            break;
                        }
                    }

                    if (returnedBook != null) {
                        System.out.println("Kitabi geri veren kisinin adi: ");
                        String personName = sc.nextLine();
                        Reader returnReader = new Reader(personName);

                        library.takeBack(returnedBook, returnReader);
                    } else {
                        System.out.println("Kitap bulunamadi.");
                    } break;
                case "0":
                    System.out.println("Sistem kapatiliyor...");
                    working =false;
                    break;

            }

        }

    }
    private static void showMenu(){
        System.out.println("--------MENU----------");
        System.out.println("1: Kutuphanedeki tum kitaplari listele");
        System.out.println("2: Yeni kitap ekle");
        System.out.println("3: Kitap ara - Isim");
        System.out.println("4: Kategorideki tum kitaplari listele");
        System.out.println("5: Yazarin Tum Kitaplarini Listele");
        System.out.println("6: Kitap odunc al");
        System.out.println("7: Odunc alinan kitabi geri ver");
        System.out.println("0: Sistemden cikis yap");
        System.out.print("Seçiminiz: ");

    }

}

