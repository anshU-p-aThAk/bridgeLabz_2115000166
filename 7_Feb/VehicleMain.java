import java.util.*;

class Vehicle {
    public int maxSpeed;
    public String fuelType;

    public Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    public void displayDetails() {
        System.out.println("Max Speed: " + maxSpeed);
        System.out.println("Fuel Type: " + fuelType);
    }
}

class Car extends Vehicle {
    public int seatCapacity;

    public Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Seat Capacity: " + seatCapacity);
    }

}

class Truck extends Vehicle {
    public int payloadCapacity;

    public Truck(int maxSpeed, String fuelType, int payloadCapacity) {
        super(maxSpeed, fuelType);
        this.payloadCapacity = payloadCapacity;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Payload Capacity: " + payloadCapacity);
    }
}

class MotorCycle extends Vehicle {
    public int engineCapacity;

    public MotorCycle(int maxSpeed, String fuelType, int engineCapacity) {
        super(maxSpeed, fuelType);
        this.engineCapacity = engineCapacity;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Engine Capacity: " + engineCapacity);
    }
}

public class VehicleMain {
    public static void main(String[] args) {
        Vehicle car = new Car(180, "Petrol", 5);
        Vehicle truck = new Truck(120, "Diesel", 1000);
        Vehicle motorcycle = new MotorCycle(150, "Petrol", 500);

        Vehicle vehicles[] = { car, truck, motorcycle };

        for (Vehicle vehicle : vehicles) {
            vehicle.displayDetails();
        }
    }
}
