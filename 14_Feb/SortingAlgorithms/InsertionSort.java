public class InsertionSort {
    public static void main(String[] args) {
        int[] employeeIDs = { 105, 102, 110, 101, 108, 103 };
        int n = employeeIDs.length;

        for (int i = 1; i < n; i++) {
            int key = employeeIDs[i];
            int j = i - 1;

            while (j >= 0 && employeeIDs[j] > key) {
                employeeIDs[j + 1] = employeeIDs[j];
                j--;
            }

            employeeIDs[j + 1] = key;
        }

        for (int id : employeeIDs) {
            System.out.print(id + " ");
        }
    }
}
