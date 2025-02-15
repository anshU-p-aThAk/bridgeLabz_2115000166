public class ConcatenateStrings {
    public static void main(String[] args) {
        String[] arr = { "Hello", " ", "World", "!", " Have", " a", " great", " day." };
        StringBuffer sb = new StringBuffer();

        for (String str : arr) {
            sb.append(str);
        }

        String result = sb.toString();
        System.out.println(result);
    }
}
