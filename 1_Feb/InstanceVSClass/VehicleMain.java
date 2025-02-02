import java.util.*;

class Vehicle {
    private String ownerName;
    private String vehicleType;
    static int registrationFee = 1000;

    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
    }

    public static void updateRegistrationFee(int newFee) {
        registrationFee = newFee;
    }
}

public class VehicleMain {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("John Doe", "Car");
        vehicle1.displayVehicleDetails();

        Vehicle vehicle2 = new Vehicle("Jane Smith", "Motorcycle");
        vehicle2.displayVehicleDetails();

        Vehicle.updateRegistrationFee(1500);

        System.out.println("Updated Registration Fee: " + Vehicle.registrationFee);
    }
}
