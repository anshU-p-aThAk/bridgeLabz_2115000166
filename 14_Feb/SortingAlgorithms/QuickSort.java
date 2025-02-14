public class QuickSort {

    public static int partition(int[] prices, int start, int end) {

        int pivot = prices[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (prices[j] < pivot) {
                i++;
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }
        int temp = prices[i + 1];
        prices[i + 1] = prices[end];
        prices[end] = temp;
        return i + 1;
    }

    public static void quickSort(int prices[], int start, int end) {

        if (start < end) {
            int pivot = partition(prices, start, end);
            quickSort(prices, start, pivot - 1);
            quickSort(prices, pivot + 1, end);
        }
    }

    public static void main(String[] args) {
        int productPrices[] = { 100, 200, 50, 500, 300, 400 };
        quickSort(productPrices, 0, productPrices.length - 1);

        System.out.println("Sorted product prices: ");
        for (int price : productPrices) {
            System.out.print(price + " ");
        }

    }
}
