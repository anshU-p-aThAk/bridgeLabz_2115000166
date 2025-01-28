import java.util.*;

public class YoungestTallestFriends {
    public static int findYoungest(int[] ages) {
        return Arrays.stream(ages).min().getAsInt();
    }

    public static int findTallest(int[] heights) {
        return Arrays.stream(heights).max().getAsInt();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[3];
        int[] heights = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of friend " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
            System.out.print("Enter height of friend " + (i + 1) + ": ");
            heights[i] = sc.nextInt();
        }
        System.out.println("Youngest Age: " + findYoungest(ages));
        System.out.println("Tallest Height: " + findTallest(heights));
    }
}
