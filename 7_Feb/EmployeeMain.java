import java.util.*;

class Employee {
    public String name;
    public int id;
    public double salary;

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {
    public int teamSize;

    public Manager(String name, int id, double salary, int teamSize) {
        super.name = name;
        super.id = id;
        super.salary = salary;
        this.teamSize = teamSize;
    }

}

class Developer extends Employee {
    public String programmingLanguage;

    public Developer(String name, int id, double salary, String programmingLanguage) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.programmingLanguage = programmingLanguage;
    }
}

class Intern extends Employee {
    public String course;

    public Intern(String name, int id, double salary, String course) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.course = course;
    }
}

public class EmployeeMain {
    public static void main(String[] args) {
        Manager manager = new Manager("John", 123, 100000, 5);
        Developer developer = new Developer("Jane", 456, 80000, "Java");
        Intern intern = new Intern("Mark", 789, 60000, "Python");

        manager.displayDetails();
        developer.displayDetails();
        intern.displayDetails();
    }
}
