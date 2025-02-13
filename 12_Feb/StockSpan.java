import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        int arr[] = { 100, 80, 60, 70, 60, 75, 85 };
        int res[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] < arr[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                res[i] = i + 1;
            } else {
                res[i] = i - s.peek();
            }

            s.push(i);
        }

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
