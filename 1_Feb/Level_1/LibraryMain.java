import java.util.*;

class Library {
    private String title;
    private String author;
    private int price;
    private boolean isAvailable;

    public Library(String title, String author, int price, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("You have successfully borrowed \"" + title + "\".");
        } else {
            System.out.println("Sorry, \"" + title + "\" is already borrowed.");
        }
    }
}

public class LibraryMain {
    public static void main(String[] args) {
        Library library = new Library("The Great Gatsby", "F. Scott Fitzgerald", 10, true);
        library.borrowBook();
    }
}
