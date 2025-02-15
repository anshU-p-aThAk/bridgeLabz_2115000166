import java.util.*;

public class FirstlLastOccurence {

    public static int findFirst(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        int result = -1;

        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                result = mid;
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    public static int findLast(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        int result = -1;

        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                result = mid;
                start = mid + 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 2, 3, 4, 5, 5, 5, 6 };
        int target = 5;
        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        System.out.println("First occurence of " + target + " is at index " + first);
        System.out.println("Last occurence of " + target + " is at index " + last);

    }
}
