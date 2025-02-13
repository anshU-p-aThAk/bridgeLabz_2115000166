import java.util.Stack;
import java.util.*;

public class SortStack {

    public static void sort(Stack<Integer> s) {

        if (s.isEmpty())
            return;

        int top = s.pop();
        sort(s);
        insertInOrder(s, top);
    }

    private static void insertInOrder(Stack<Integer> s, int top) {
        if (s.isEmpty() || s.peek() < top) {
            s.push(top);
            return;
        }

        int n = s.pop();
        insertInOrder(s, top);
        s.push(n);
    }

    public static void printStack(Stack<Integer> stack) {
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(5);
        s.push(45);
        s.push(56);
        sort(s);
        printStack(s);
    }

}
