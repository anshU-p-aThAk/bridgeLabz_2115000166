import java.util.*;

class Vehicle {
    protected int maxSpeed;
    protected String model;

    public Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    public void refuel() {
        System.out.println("Refueling the vehicle...");
    }
}

class ElectricVehicle extends Vehicle {
    public ElectricVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    @Override
    public void refuel() {
        System.out.println("Electric vehicle does not require fuel, charging instead...");
    }
}

class PetrolVehicle extends Vehicle {
    public PetrolVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    @Override
    public void refuel() {
        System.out.println("Refueling the petrol vehicle...");
    }
}

public class VehicleManagement {
    public static void main(String[] args) {
        Vehicle ev = new ElectricVehicle(120, "Model X");
        ev.refuel();

        Vehicle pv = new PetrolVehicle(180, "Model S");
        pv.refuel();
    }
}
