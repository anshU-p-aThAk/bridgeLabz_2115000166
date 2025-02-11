import java.util.*;

class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next, prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieList {
    private Movie head, tail;

    public void addMovieAtStart(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = newMovie;
            tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }

    }

    public void addMovieAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = newMovie;
            tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    public void addMovieAtPosition(String title, String director, int year, double rating, int position) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = newMovie;
            tail = newMovie;
        } else if (position == 1) {
            addMovieAtStart(title, director, year, rating);
            return;
        }

        Movie temp = head;
        int count = 1;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Position out of bounds. Adding at the end.");
            addMovieAtEnd(title, director, year, rating);
            return;
        }

        newMovie.next = temp.next;
        newMovie.prev = temp;
        if (temp.next != null) {
            temp.next.prev = newMovie;
        } else {
            tail = newMovie;
        }
        temp.next = newMovie;

        System.out.println("Movie added at position " + position + ": " + title);
    }

    public void searchMovieByDirector(String director) {
        Movie temp = head;
        while (temp != null) {
            if (temp.director.equals(director)) {
                System.out.println("Movie found:");
                System.out.println("Title: " + temp.title);
                System.out.println("Director: " + temp.director);
                System.out.println("Year: " + temp.year);
                System.out.println("Rating: " + temp.rating);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    public void searchMovieByRating(double rating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.rating == rating) {
                System.out.println("Movie found:");
                System.out.println("Title: " + temp.title);
                System.out.println("Director: " + temp.director);
                System.out.println("Year: " + temp.year);
                System.out.println("Rating: " + temp.rating);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    public void displayForward() {
        Movie temp = head;
        while (temp != null) {
            System.out.println("Title: " + temp.title);
            System.out.println("Director: " + temp.director);
            System.out.println("Year: " + temp.year);
            System.out.println("Rating: " + temp.rating);
            System.out.println("-------------------");
            temp = temp.next;
        }
    }

    public void displayReverse() {
        Movie temp = tail;
        while (temp != null) {
            System.out.println("Title: " + temp.title);
            System.out.println("Director: " + temp.director);
            System.out.println("Year: " + temp.year);
            System.out.println("Rating: " + temp.rating);
            System.out.println("-------------------");
            temp = temp.prev;
        }
    }

    public void updateMovieRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = newRating;
                System.out.println("Updated rating for " + title + " to " + newRating);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found: " + title);
    }

    public void removeMovie(String title) {
        if (head == null) {
            System.out.println("No movies in the list.");
            return;
        }

        Movie temp = head;
        while (temp != null && !temp.title.equals(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found: " + title);
            return;
        }

        if (temp == head) {
            head = head.next;
            if (head != null)
                head.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        System.out.println("Movie removed: " + title);
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieList movieList = new MovieList();
        movieList.addMovieAtStart("The Shawshank Redemption", "Frank Darabont", 1994, 9.3);
        movieList.addMovieAtEnd("The Godfather", "Francis Ford Coppola", 1972, 9.2);
        movieList.addMovieAtPosition("Inception", "Christopher", 2010, 9, 2);
        movieList.displayForward();
        movieList.displayReverse();
        movieList.searchMovieByDirector("Christopher");
        movieList.searchMovieByRating(9);
        movieList.updateMovieRating("Inception", 9.2);
        movieList.removeMovie("The Godfather");
        movieList.displayForward();
    }
}
