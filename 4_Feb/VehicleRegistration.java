import java.util.*;

class Vehicle {
    private static double registrationFee = 5000;
    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;

    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public void displayDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
        }
    }
}

public class VehicleRegistration {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("John", "Car", "UP1234");
        vehicle1.displayDetails();
        Vehicle.updateRegistrationFee(5500);
        vehicle1.displayDetails();
    }
}
