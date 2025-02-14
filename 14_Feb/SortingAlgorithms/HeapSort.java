import java.util.Arrays;

public class HeapSort {

	public static void heapSort(int[] salaries) {
		int n = salaries.length;

		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(salaries, n, i);
		}

		for (int i = n - 1; i > 0; i--) {
			swap(salaries, 0, i);
			heapify(salaries, i, 0);
		}
	}

	private static void heapify(int[] salaries, int n, int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < n && salaries[left] > salaries[largest]) {
			largest = left;
		}

		if (right < n && salaries[right] > salaries[largest]) {
			largest = right;
		}

		if (largest != i) {
			swap(salaries, i, largest);
			heapify(salaries, n, largest);
		}
	}

	private static void swap(int[] salaries, int i, int j) {
		int temp = salaries[i];
		salaries[i] = salaries[j];
		salaries[j] = temp;
	}

	public static void main(String[] args) {
		int[] salaries = { 50000, 75000, 30000, 90000, 60000, 40000 };

		heapSort(salaries);
		for (int salary : salaries) {
			System.out.print(salary + " ");
		}
	}
}
