import java.util.*;

interface Worker {
    void performDuties();
}

class Person {
    protected String name;
    protected int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

class Chef extends Person implements Worker {
    public Chef(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println("Cooking food.");
    }

    public void displayDetails() {
        super.displayDetails();
    }

}

class Waiter extends Person implements Worker {
    public Waiter(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println("Serving customers.");
    }

    public void displayDetails() {
        super.displayDetails();
    }
}

public class Restaurant {
    public static void main(String[] args) {
        Chef chef = new Chef("John", 1);
        Waiter waiter = new Waiter("Jane", 2);

        chef.performDuties();
        waiter.performDuties();
    }
}
