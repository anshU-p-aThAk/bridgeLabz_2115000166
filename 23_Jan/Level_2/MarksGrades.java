import java.util.Scanner;

public class MarksGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks for Physics: ");
        double physics = sc.nextDouble();
        System.out.print("Enter marks for Chemistry: ");
        double chemistry = sc.nextDouble();
        System.out.print("Enter marks for Maths: ");
        double maths = sc.nextDouble();

        double total = physics + chemistry + maths;
        double average = total / 3;
        String grade;
        String remarks;

        if (average >= 90) {
            grade = "A+";
            remarks = "Excellent!";
        } else if (average >= 80) {
            grade = "A";
            remarks = "Very Good!";
        } else if (average >= 70) {
            grade = "B";
            remarks = "Good!";
        } else if (average >= 60) {
            grade = "C";
            remarks = "Fair!";
        } else if (average >= 50) {
            grade = "D";
            remarks = "Pass!";
        } else {
            grade = "F";
            remarks = "Fail!";
        }

        System.out.println("Total Marks: " + total);
        System.out.println("Average Marks: " + average);
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);
    }
}
