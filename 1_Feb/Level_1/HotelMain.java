import java.util.*;

class Hotel {
    private String guestName;
    private String roomTypes;
    private int nights;

    public Hotel(String guestName, String roomTypes, int nights) {
        this.guestName = guestName;
        this.roomTypes = roomTypes;
        this.nights = nights;
    }

    public Hotel() {
        this.guestName = "";
        this.roomTypes = "";
        this.nights = 0;
    }

    public Hotel(Hotel other) {
        this.guestName = other.guestName;
        this.roomTypes = other.roomTypes;
        this.nights = other.nights;
    }

    public void display() {
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomTypes);
        System.out.println("Nights: " + nights);
    }

}

public class HotelMain {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("John Doe", "Suite", 3);
        hotel.display();
        Hotel hotel2 = new Hotel();
        hotel2.display();
        Hotel hotel3 = new Hotel(hotel);
        hotel3.display();
    }
}
