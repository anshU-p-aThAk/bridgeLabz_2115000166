import java.util.*;

class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Teacher extends Person {
    protected String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public void displayRole() {
        super.displayDetails();
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject);
    }
}

class Student extends Person {
    protected int grade;

    public Student(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }

    public void displayRole() {
        super.displayDetails();
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade);
    }
}

class Staff extends Person {
    protected String position;

    public Staff(String name, int age, String position) {
        super(name, age);
        this.position = position;
    }

    public void displayRole() {
        super.displayDetails();
        System.out.println("Role: Staff");
        System.out.println("Position: " + position);
    }
}

public class School {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("John", 35, "Mathematics");
        Student student = new Student("Jane", 12, 9);
        Staff staff = new Staff("Bob", 40, "Librarian");

        teacher.displayRole();
        student.displayRole();
        staff.displayRole();
    }
}
