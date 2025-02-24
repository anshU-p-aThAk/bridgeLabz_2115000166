import java.util.ArrayList;

public class SuppressWarningsExample {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList list = new ArrayList(); // No generics used
        list.add("Hello");
        System.out.println(list.get(0)); // Output: Hello
    }
}
