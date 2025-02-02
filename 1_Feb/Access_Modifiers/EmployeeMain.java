import java.util.*;

class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class Manager extends Employee {
    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
    }
}

public class EmployeeMain {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.employeeID = 101;
        e.setSalary(50000.0);

        Manager m = new Manager();
        m.employeeID = 102;
        m.department = "Sales";
        m.displayEmployeeInfo();
    }
}
