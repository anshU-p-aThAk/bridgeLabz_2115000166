public class LinearSearchSentence {
    public static String findSentence(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
                "This is a sample sentence.",
                "Java is a powerful programming language.",
                "Linear search is simple and easy to understand."
        };
        String word = "Java";
        System.out.println(findSentence(sentences, word));
    }
}
