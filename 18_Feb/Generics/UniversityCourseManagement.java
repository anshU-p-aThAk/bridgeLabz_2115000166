import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    public abstract String getName();

    public String toString() {
        return getName();
    }
}

class ExamCourse extends CourseType {
    public String getName() {
        return "Exam-Based";
    }
}

class AssignmentCourse extends CourseType {
    public String getName() {
        return "Assignment-Based";
    }
}

class ResearchCourse extends CourseType {
    public String getName() {
        return "Research-Based";
    }
}

class Course<T extends CourseType> {
    private String courseName;
    private T courseType;
    private String department;

    public Course(String courseName, T courseType, String department) {
        this.courseName = courseName;
        this.courseType = courseType;
        this.department = department;
    }

    public String getCourseName() {
        return courseName;
    }

    public T getCourseType() {
        return courseType;
    }

    public String getDepartment() {
        return department;
    }

    public String toString() {
        return courseName + " (" + courseType + " | " + department + ")";
    }
}

class University {
    private List<Course<? extends CourseType>> courses = new ArrayList<>();

    public void addCourse(Course<? extends CourseType> course) {
        courses.add(course);
    }

    public void displayCourses() {
        for (Course<? extends CourseType> course : courses) {
            System.out.println(course);
        }
    }
}

public class UniversityCourseManagement {
    public static void main(String[] args) {
        University university = new University();

        Course<ExamCourse> math = new Course<>("Mathematics", new ExamCourse(), "Science");
        Course<AssignmentCourse> literature = new Course<>("English Literature", new AssignmentCourse(), "Arts");
        Course<ResearchCourse> aiResearch = new Course<>("Artificial Intelligence", new ResearchCourse(),
                "Computer Science");

        university.addCourse(math);
        university.addCourse(literature);
        university.addCourse(aiResearch);

        System.out.println("University Courses:");
        university.displayCourses();
    }
}
