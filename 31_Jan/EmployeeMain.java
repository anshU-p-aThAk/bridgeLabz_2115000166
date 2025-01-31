import java.util.*;

class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void getDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }
}

public class EmployeeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name, ID, and salary: ");
        String name = scanner.nextLine();
        int id = scanner.nextInt();
        double salary = scanner.nextDouble();
        Employee employee1 = new Employee(name, id, salary);
        employee1.getDetails();
    }
}