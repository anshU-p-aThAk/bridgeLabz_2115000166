class FirstNegative {
    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 7, -2, 8, -6 };
        int index = findFirstNegative(arr);
        System.out.println("First negative number index: " + index);
    }
}
