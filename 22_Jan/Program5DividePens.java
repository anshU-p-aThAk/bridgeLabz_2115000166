// Program 5: Pens division among students
public class Program5DividePens {
    public static void main(String[] args) {
        int pens = 14, students = 3;
        int pensPerStudent = pens / students;
        int remainingPens = pens % students;
        System.out.println(pensPerStudent);
        System.out.println(remainingPens);
    }
}
