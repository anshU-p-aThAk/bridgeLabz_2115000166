import java.util.*;

class Course {
    protected String courseName;
    protected int duration;

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public void getCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
    }
}

class OnlineCourse extends Course {
    protected String platform;
    protected boolean isRecorded;

    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    public void getCourseDetails() {
        super.getCourseDetails();
        System.out.println("Platform: " + platform);
        System.out.println("Is Recorded: " + isRecorded);
    }
}

class PaidOnlineCourse extends OnlineCourse {
    protected double fee;
    protected double discount;

    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee,
            double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    public void getCourseDetails() {
        super.getCourseDetails();
        System.out.println("Fee: " + fee);
        System.out.println("Discount: " + discount + " %");
    }
}

public class EducationalCourse {
    public static void main(String[] args) {
        PaidOnlineCourse paidOnlineCourse = new PaidOnlineCourse("Java Programming", 6, "Udemy", true, 5000.0, 0.2);
        paidOnlineCourse.getCourseDetails();
    }
}
