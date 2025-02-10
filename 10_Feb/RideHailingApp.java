import java.util.*;

interface GPS {
    String getCurrentLocation();

    void updateLocation(String location);
}

abstract class Vehicle implements GPS {
    private final int vehicleId;
    private final String driverName;
    private final double ratePerKm;
    private String currentLocation;

    public Vehicle(int vehicleId, String driverName, double ratePerKm, String currentLocation) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = currentLocation;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: " + ratePerKm);
        System.out.println("Current Location: " + currentLocation);
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
        System.out.println("Location updated to: " + newLocation);
    }

}

class Car extends Vehicle {
    public Car(int vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
}

class Bike extends Vehicle {
    public Bike(int vehicleId, String driverName, double ratePerkm, String currentLocation) {
        super(vehicleId, driverName, ratePerkm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
}

class Auto extends Vehicle {
    public Auto(int vehicleId, String driverName, double ratePerkm, String currentLocation) {
        super(vehicleId, driverName, ratePerkm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
}

public class RideHailingApp {
    public static void main(String[] args) {
        Vehicle[] vehicles = { new Car(1, "John", 10.0, "Location A"), new Bike(2, "Alice", 15.0, "Location B"),
                new Auto(3, "Bob", 20.0, "Location C") };

        for (Vehicle vehicle : vehicles) {
            vehicle.getVehicleDetails();
            vehicle.updateLocation("Location D");
        }
    }
}
