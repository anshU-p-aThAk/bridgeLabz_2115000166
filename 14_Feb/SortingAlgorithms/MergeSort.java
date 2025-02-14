import java.util.*;

public class MergeSort {

    public static void mergeSort(int prices[], int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(prices, start, mid);
            mergeSort(prices, mid + 1, end);
            merge(prices, start, mid, end);
        }
    }

    public static void merge(int prices[], int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;

        int left[] = new int[n1];
        int right[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = prices[start + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = prices[mid + 1 + i];
        }

        int i = 0, j = 0, k = start;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                prices[k] = left[i];
                i++;
            } else {
                prices[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            prices[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            prices[k] = right[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args) {
        int bookPrices[] = { 100, 200, 50, 500, 300, 400 };
        mergeSort(bookPrices, 0, bookPrices.length - 1);

        System.out.println("Sorted book prices:");
        for (int price : bookPrices) {
            System.out.print(price + " ");
        }
    }
}
