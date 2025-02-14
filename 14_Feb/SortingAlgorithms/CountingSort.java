public class CountingSort {
    public static void main(String[] args) {
        int[] ages = { 12, 15, 14, 10, 18, 17, 12, 16, 14, 13, 11, 15, 10, 18 };
        int maxAge = 18;
        int[] count = new int[maxAge + 1];
        int[] sortedAges = new int[ages.length];

        for (int age : ages) {
            count[age]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = ages.length - 1; i >= 0; i--) {
            sortedAges[--count[ages[i]]] = ages[i];
        }

        for (int i = 0; i < sortedAges.length; i++) {
            System.out.print(sortedAges[i] + " ");
        }
    }

}
