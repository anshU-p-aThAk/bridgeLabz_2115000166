import java.util.*;

class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
}

class PostGraduateStudent extends Student {
    public void getName() {
        System.out.println(name);
    }
}

public class StudentMain {
    public static void main(String[] args) {
        Student student = new Student();
        student.rollNumber = 1;
        student.name = "John Doe";
        student.setCGPA(3.5);

        PostGraduateStudent postGraduateStudent = new PostGraduateStudent();
        postGraduateStudent.name = "Jane Doe";
        postGraduateStudent.getName();
    }
}