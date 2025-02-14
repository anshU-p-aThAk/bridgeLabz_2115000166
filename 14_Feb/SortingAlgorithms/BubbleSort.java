public class BubbleSort {
    public static void main(String[] args) {
        int[] marks = { 78, 45, 89, 56, 90, 34, 67 };
        int n = marks.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                }
            }
        }
        System.out.println("Sorted marks: ");
        for (int mark : marks) {
            System.out.print(mark + " ");

        }
    }
}
