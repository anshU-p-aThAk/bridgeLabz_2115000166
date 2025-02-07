import java.util.*;

class Book {
    protected String title;
    protected String publicationYear;

    public Book(String title, String publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

class Author extends Book {
    protected String authorName;

    public Author(String title, String publicationYear, String authorName) {
        super(title, publicationYear);
        this.authorName = authorName;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author: " + authorName);
    }
}

public class Library {
    public static void main(String[] args) {
        Author book1 = new Author("The Great Gatsby", "1925", "F. Scott Fitzgerald");
        book1.displayInfo();
    }
}
