import java.util.*;

class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double rate;

    public CarRental(String customerName, String carModel, int rentalDays, double rate) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.rate = rate;
    }

    public void totalCost() {
        double totalCost = rentalDays * rate;
        System.out.println("Total cost: " + totalCost);
    }
}

public class CarRentalMain {
    public static void main(String[] args) {
        CarRental carRental = new CarRental("John Doe", "Toyota Camry", 5, 50.0);
        carRental.totalCost();
    }
}
