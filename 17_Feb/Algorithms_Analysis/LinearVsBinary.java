import java.util.*;

public class LinearVsBinary {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sizes = { 1000, 10000, 1000000 };
        Random r = new Random();

        for (int size : sizes) {
            int[] data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = r.nextInt(size);
            }

            int target = data[r.nextInt(size)];

            long start = System.nanoTime();
            linearSearch(data, target);
            long linearTime = System.nanoTime() - start;

            Arrays.sort(data);
            start = System.nanoTime();
            binarySearch(data, target);
            long binaryTime = System.nanoTime() - start;

            System.out.println("Dataset Size: " + size);
            System.out.println("Linear Search Time: " + linearTime / 1e6 + " ms");
            System.out.println("Binary Search Time: " + binaryTime / 1e6 + " ms");

        }
    }
}
