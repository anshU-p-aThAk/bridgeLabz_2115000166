import java.util.ArrayList;
import java.util.List;

interface Insurable {
    double calculateInsurance();

    String getInsuranceDetails();
}

abstract class Vehicle implements Insurable {
    private final String vehicleNumber;
    private final String type;
    private final double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public abstract double calculateRentalCost(int days);

    public void displayDetails() {
        System.out.println(
                "Vehicle Number: " + vehicleNumber + ", Type: " + type + ", Rental Rate: ₹" + rentalRate + " per day");
    }

    @Override
    public double calculateInsurance() {
        return 0;
    }

    @Override
    public String getInsuranceDetails() {
        return "No insurance available";
    }
}

class Car extends Vehicle {
    private static final double INSURANCE_RATE = 0.02;

    public Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return calculateRentalCost(1) * INSURANCE_RATE;
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance Rate: 2% of rental cost";
    }
}

class Bike extends Vehicle {
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 0;
    }

    @Override
    public String getInsuranceDetails() {
        return "No insurance available";
    }
}

class Truck extends Vehicle {
    private static final double INSURANCE_RATE = 0.05;

    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return calculateRentalCost(1) * INSURANCE_RATE;
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance Rate: 5% of rental cost";
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("C101", 1500));
        vehicles.add(new Bike("B202", 500));
        vehicles.add(new Truck("T303", 3000));

        for (Vehicle vehicle : vehicles) {
            vehicle.displayDetails();
            int rentalDays = 5;
            double rentalCost = vehicle.calculateRentalCost(rentalDays);
            double insuranceCost = vehicle.calculateInsurance();

            System.out.println("Rental Cost for " + rentalDays + " days: " + rentalCost);
            System.out.println(vehicle.getInsuranceDetails());
            System.out.println("Insurance Cost: " + insuranceCost);
            System.out.println("Total Cost: " + (rentalCost + insuranceCost) + "\n");
        }
    }
}
