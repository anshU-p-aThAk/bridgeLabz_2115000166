import java.util.*;

interface Refuelable {
    void refuel();
}

class Vehicle {
    protected int maxSpeed;
    protected String model;

    public Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }
}

class ElectricVehicle extends Vehicle {
    public ElectricVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    public void charge() {
        System.out.println("Charging the vehicle...");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    public PetrolVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    public void refuel() {
        System.out.println("Refueling the vehicle...");
    }
}

public class VehicleManagement {
    public static void main(String[] args) {
        ElectricVehicle electricVehicle = new ElectricVehicle(120, "Model X");
        electricVehicle.charge();
        PetrolVehicle petrolVehicle = new PetrolVehicle(180, "Model S");
        petrolVehicle.refuel();
    }
}
