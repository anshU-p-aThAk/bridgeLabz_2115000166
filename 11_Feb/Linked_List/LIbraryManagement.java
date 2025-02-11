class Book {
    String title, author, genre;
    int bookId;
    boolean isAvailable;
    Book next, prev;

    public Book(int bookId, String title, String author, String genre, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
        this.next = this.prev = null;
    }
}

class Library {
    private Book head = null, tail = null;
    private int totalBooks = 0;

    public void addBookAtBeginning(int bookId, String title, String author, String genre, boolean isAvailable) {
        Book newBook = new Book(bookId, title, author, genre, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        totalBooks++;
        System.out.println("Book added at the beginning: " + title);
    }

    public void addBookAtEnd(int bookId, String title, String author, String genre, boolean isAvailable) {
        Book newBook = new Book(bookId, title, author, genre, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        totalBooks++;
        System.out.println("Book added at the end: " + title);
    }

    public void removeBook(int bookId) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        Book temp = head;
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Book not found: " + bookId);
            return;
        }
        if (temp == head)
            head = head.next;
        if (temp == tail)
            tail = tail.prev;
        if (temp.prev != null)
            temp.prev.next = temp.next;
        if (temp.next != null)
            temp.next.prev = temp.prev;
        totalBooks--;
        System.out.println("Book removed: " + temp.title);
    }

    public void searchByTitle(String title) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                System.out.println("Book Found: " + temp.title + " | ID: " + temp.bookId + " | Author: " + temp.author
                        + " | Genre: " + temp.genre + " | Available: " + temp.isAvailable);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    public void searchByAuthor(String author) {
        Book temp = head;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                System.out.println("Book Found: " + temp.title + " | ID: " + temp.bookId + " | Genre: " + temp.genre
                        + " | Available: " + temp.isAvailable);
            }
            temp = temp.next;
        }
    }

    public void updateAvailability(int bookId, boolean isAvailable) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = isAvailable;
                System.out.println("Availability updated for Book ID: " + bookId);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found: " + bookId);
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        Book temp = head;
        System.out.println("Library Books (Forward Order):");
        while (temp != null) {
            System.out.println("ID: " + temp.bookId + ", Title: " + temp.title + ", Author: " + temp.author
                    + ", Genre: " + temp.genre + ", Available: " + temp.isAvailable);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }
        Book temp = tail;
        System.out.println("Library Books (Reverse Order):");
        while (temp != null) {
            System.out.println("ID: " + temp.bookId + ", Title: " + temp.title + ", Author: " + temp.author
                    + ", Genre: " + temp.genre + ", Available: " + temp.isAvailable);
            temp = temp.prev;
        }
    }

    public void countBooks() {
        System.out.println("Total Books in Library: " + totalBooks);
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBookAtBeginning(1, "The Alchemist", "Paulo Coelho", "Fiction", true);
        library.addBookAtEnd(2, "Atomic Habits", "James Clear", "Self-help", true);
        library.addBookAtEnd(3, "Clean Code", "Robert C. Martin", "Programming", false);
        library.addBookAtBeginning(4, "1984", "George Orwell", "Dystopian", true);

        library.displayForward();
        library.displayReverse();
        library.updateAvailability(2, false);
        library.searchByTitle("1984");
        library.searchByAuthor("James Clear");
        library.countBooks();
        library.removeBook(3);
        library.displayForward();
    }
}
