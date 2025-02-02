import java.util.*;

class Course {
    private String courseName;
    private int duration;
    private int fees;
    static String instituteName;

    public Course(String courseName, int duration, int fees) {
        this.courseName = courseName;
        this.duration = duration;
        this.fees = fees;
    }

    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fees: " + fees);
    }

    public static void updateInstituteName(String instituteName) {
        Course.instituteName = instituteName;
    }
}

public class CourseMain {
    public static void main(String[] args) {
        Course course1 = new Course("Java", 6, 50000);
        course1.displayCourseDetails();

        Course course2 = new Course("Python", 4, 40000);
        course2.displayCourseDetails();

        Course.updateInstituteName("ABC College");

        System.out.println("Institute Name: " + Course.instituteName);
    }
}
