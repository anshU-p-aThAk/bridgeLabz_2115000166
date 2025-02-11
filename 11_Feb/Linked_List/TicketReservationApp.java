class Ticket {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    private Ticket head = null;
    private Ticket tail = null;
    private int count = 0;

    public void bookTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = tail = newTicket;
            tail.next = head;
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head;
        }
        count++;
        System.out.println("Ticket booked successfully for " + customerName);
    }

    public void cancelTicket(int ticketID) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket current = head, prev = tail;
        boolean found = false;

        do {
            if (current.ticketID == ticketID) {
                found = true;
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = current.next;
                }
                count--;
                System.out.println("Ticket " + ticketID + " canceled.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        if (!found)
            System.out.println("Ticket ID not found.");
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket current = head;
        System.out.println("Booked Tickets:");
        do {
            System.out.println("Ticket ID: " + current.ticketID + ", Customer: " + current.customerName + ", Movie: "
                    + current.movieName + ", Seat: " + current.seatNumber + ", Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    public void searchByCustomerOrMovie(String searchKey) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket current = head;
        boolean found = false;
        do {
            if (current.customerName.equalsIgnoreCase(searchKey) || current.movieName.equalsIgnoreCase(searchKey)) {
                System.out.println("Ticket ID: " + current.ticketID + ", Customer: " + current.customerName
                        + ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Time: "
                        + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found)
            System.out.println("No matching ticket found.");
    }

    public void countTickets() {
        System.out.println("Total booked tickets: " + count);
    }
}

public class TicketReservationApp {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        system.bookTicket(101, "Anshu Pathak", "Inception", "A1", "10:00 AM");
        system.bookTicket(102, "Disha Verma", "Interstellar", "B2", "1:00 PM");
        system.bookTicket(103, "Rahul Kumar", "The Dark Knight", "C3", "3:00 PM");

        system.displayTickets();

        system.cancelTicket(102);

        system.displayTickets();

        system.searchByCustomerOrMovie("Inception");

        system.countTickets();
    }
}
