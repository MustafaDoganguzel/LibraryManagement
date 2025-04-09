import model.book.Book;
import model.person.Author;
import model.person.Person;
import model.person.Reader;

import java.util.*;

public class Main {

    static Map<String, String> userDatabase = new HashMap<>();
    static Map<String, Person> userObjects = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n👉 1: Sisteme Kayıt Ol");
            System.out.println("👉 2: Giriş Yap");
            System.out.println("👉 0: Çıkış");
            System.out.print("Seçiminiz: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":

                    System.out.print("Yeni kullanıcı adı girin: ");
                    String newUsername = sc.nextLine().toLowerCase().trim();

                    if (userDatabase.containsKey(newUsername)) {
                        System.out.println("❗ Bu kullanıcı adı zaten kayıtlı.");
                    } else {
                        System.out.print("Şifre girin: ");
                        String newPassword = sc.nextLine().trim();
                        userDatabase.put(newUsername, newPassword);

                        System.out.print("Title girin (reader/author): ");
                        String title = sc.nextLine().trim();

                        if (title.equalsIgnoreCase("reader")) {
                            Reader reader = new Reader(newUsername);
                            userObjects.put(newUsername, reader);
                            System.out.println("✅ Kayıt başarılı. Reader olarak artık giriş yapabilirsiniz.");
                        } else if (title.equalsIgnoreCase("author")) {
                            Author author = new Author(newUsername);
                            userObjects.put(newUsername, author);
                            System.out.println("✅ Kayıt başarılı. Author olarak artık giriş yapabilirsiniz.");
                        } else {
                            System.out.println("❌ Geçersiz unvan.");
                        }
                    }
                    break;

                case "2":
                    System.out.print("Kullanıcı adınız: ");
                    String username = sc.nextLine().toLowerCase().trim();

                    System.out.print("Şifreniz: ");
                    String password = sc.nextLine().trim();

                    if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
                        System.out.println("\n✅ Giriş başarılı. Hoş geldiniz, " + username + "!");

                        Person user = userObjects.get(username);
                        showMenu(user, sc);
                    } else {
                        System.out.println("❌ Kullanıcı adı veya şifre hatalı.");
                    }
                    break;

                case "0":
                    System.out.println("👋 Sistemden çıkılıyor...");
                    return;

                default:
                    System.out.println("⚠️ Geçersiz seçim. Lütfen 1, 2 veya 0 girin.");
            }
        }
    }

    public static void showMenu(Person user, Scanner sc) {

        if (!(user instanceof Reader)) {
            System.out.println("❗ Sadece Reader kullanıcılar bu menüyü görebilir.");
            return;
        }

        Reader reader = (Reader) user;

        System.out.println("\n------ MENÜ ------");

        while (true) {
            System.out.println("1: Kitap Ödünç Al");
            System.out.println("2: Ödünç Alınan Kitabı İade Et");
            System.out.println("3: Ödünç Alınan Kitapları Görüntüle");
            System.out.println("0: Ana menüye dön");
            System.out.print("Seçiminiz: ");

            String secim = sc.nextLine();

            switch (secim) {
                case "1":
                    System.out.println("📚 Ödünç alınacak kitabı girin (kitapAdı yazarAdı):");
                    String bookInput = sc.nextLine();
                    String[] promptBook = bookInput.trim().toLowerCase().split(" ");

                    if (promptBook.length < 2) {
                        System.out.println("⚠️ Lütfen kitap ismi ve yazar ismi girin.");
                        break;
                    }

                    Book b1 = new Book(promptBook[0], new Author(promptBook[1]), 2);
                    reader.barrowBook(b1);
                    break;

                case "2":
                    System.out.println("🔁 İade etmek istediğiniz kitabı girin (kitapAdı yazarAdı):");
                    String returnInput = sc.nextLine();
                    String[] returnBook = returnInput.trim().toLowerCase().split(" ");

                    if (returnBook.length < 2) {
                        System.out.println("⚠️ Lütfen kitap ismi ve yazar ismi girin.");
                        break;
                    }

                    Book returnedBook = new Book(returnBook[0], new Author(returnBook[1]), 2);
                    reader.returnBook(returnedBook);
                    reader.showBook();
                    break;

                case "3":
                    System.out.println("📖 Ödünç alınan kitaplar:");
                    reader.showBook();
                    break;

                case "0":
                    System.out.println("↩ Ana menüye dönülüyor...");
                    return;

                default:
                    System.out.println("⚠️ Geçersiz seçim. Lütfen 1, 2, 3 veya 0 girin.");
            }
        }
    }
}
