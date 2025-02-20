import java.util.*;

public class RotateList {
    public static <T> void rotateList(List<T> list, int k) {
        int n = list.size();
        k = k % n; 

        
        reverse(list, 0, k - 1);
        
        reverse(list, k, n - 1);
        
        reverse(list, 0, n - 1);
    }

    
    private static <T> void reverse(List<T> list, int start, int end) {
        while (start < end) {
            T temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        
        List<Integer> inputList = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int rotateBy = 2;

        System.out.println("Original List: " + inputList);
        rotateList(inputList, rotateBy);
        System.out.println("Rotated List: " + inputList);
    }
}
