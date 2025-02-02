import java.util.*;

class Book {
    public String ISBN;
    protected String title;
    private String author;

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}

class EBook extends Book {
    public void displayDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
    }
}

public class BookMain {
    public static void main(String[] args) {
        Book b = new Book();
        b.ISBN = "123456";
        b.setAuthor("J.K. Rowling");

        EBook eb = new EBook();
        eb.ISBN = "654321";
        eb.title = "Digital Java";
        eb.displayDetails();
    }
}
