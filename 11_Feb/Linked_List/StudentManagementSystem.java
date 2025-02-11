import java.util.*;

class Student {
    int rollNumber;
    String name;
    int age;
    char grade;
    Student next;

    public Student(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    private Student head;

    public void insertAtStart(int rollNumber, String name, int age, char grade) {
        Student newNode = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAtEnd(int rollNumber, String name, int age, char grade) {
        Student newNode = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newNode;
        } else {
            Student current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void insertAtPosition(int rollNumber, String name, int age, char grade, int position) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
        } else if (position == 1) { // Insert at the beginning
            newStudent.next = head;
            head = newStudent;
            System.out.println("Student added at position " + position);
            return;
        }

        Student temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        newStudent.next = temp.next;
        temp.next = newStudent;
        System.out.println("Student added at position " + position);
    }

    public void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.rollNumber == rollNumber) {
            head = head.next;
            System.out.println("Student with roll number " + rollNumber + " deleted.");
            return;
        }

        Student temp = head, prev = null;
        while (temp != null && temp.rollNumber != rollNumber) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Student not found.");
            return;
        }

        prev.next = temp.next; // Unlink node
        System.out.println("Student with Roll Number " + rollNumber + " deleted.");
    }

    public void searchByRollNumber(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                System.out.println("Student found:");
                System.out.println("Roll Number: " + temp.rollNumber);
                System.out.println("Name: " + temp.name);
                System.out.println("Age: " + temp.age);
                System.out.println("Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        return;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Student temp = head;
        while (temp != null) {
            System.out.println("Roll Number: " + temp.rollNumber);
            System.out.println("Name: " + temp.name);
            System.out.println("Age: " + temp.age);
            System.out.println("Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    public void upgradeGrade(int rollNumber, char newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                temp.grade = newGrade;
                System.out.println("Grade of student with roll number " + rollNumber + " upgraded to " + newGrade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {

        StudentLinkedList studentList = new StudentLinkedList();
        studentList.insertAtStart(1, "John", 20, 'A');
        studentList.insertAtEnd(2, "Jane", 21, 'B');
        studentList.insertAtPosition(3, "Bob", 22, 'C', 2);

        studentList.display();
        studentList.deleteByRollNumber(3);
        studentList.searchByRollNumber(1);
        studentList.upgradeGrade(2, 'D');
        studentList.display();
    }

}