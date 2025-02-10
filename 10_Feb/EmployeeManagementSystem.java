abstract class Employee {
    private final int employeeId;
    private final String name;
    private final double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Salary: " + calculateSalary());
    }
}

interface Department {
    void assignDepartment(String department);
    String getDepartmentDetails();
}

class FullTimeEmployee extends Employee implements Department {
    private final double monthlySalary;
    private String department;

    public FullTimeEmployee(int employeeId, String name, double baseSalary, double monthlySalary) {
        super(employeeId, name, baseSalary);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }

    @Override
    public void assignDepartment(String department) {
        this.department = department;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + (department != null ? department : "Not Assigned");
    }
}

class PartTimeEmployee extends Employee implements Department {
    private final int hoursWorked;
    private final double hourlyRate;
    private String department;

    public PartTimeEmployee(int employeeId, String name, double baseSalary, int hoursWorked, double hourlyRate) {
        super(employeeId, name, baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    @Override
    public void assignDepartment(String department) {
        this.department = department;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + (department != null ? department : "Not Assigned");
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Department emp1 = new FullTimeEmployee(101, "Alice", 50000, 60000);
        Department emp2 = new PartTimeEmployee(102, "Bob", 20000, 120, 50);

        emp1.assignDepartment("IT");
        emp2.assignDepartment("HR");

        Department[] employees = {emp1, emp2};
        for (Department emp : employees) {
            Employee e = (Employee) emp;
            e.displayDetails();
            System.out.println(emp.getDepartmentDetails());
            System.out.println();
        }
    }
}
