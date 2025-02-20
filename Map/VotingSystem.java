import java.util.*;

public class VotingSystem {

    private static Map<String, Integer> votesMap = new HashMap<>();
    private static Map<String, Integer> orderedVotesMap = new LinkedHashMap<>();
    private static Map<String, Integer> sortedVotesMap = new TreeMap<>(Comparator.comparing(votesMap::get).reversed());

    public static void addVote(String candidate) {
        votesMap.put(candidate, votesMap.getOrDefault(candidate, 0) + 1);
        orderedVotesMap.put(candidate, orderedVotesMap.getOrDefault(candidate, 0) + 1);
        sortedVotesMap.put(candidate, sortedVotesMap.getOrDefault(candidate, 0) + 1);
    }

    public static void displayVotesInHashMap() {
        System.out.println("Votes in HashMap (No order): ");
        votesMap.forEach((candidate, votes) -> System.out.println(candidate + ": " + votes));
    }

    public static void displayVotesInLinkedHashMap() {
        System.out.println("Votes in LinkedHashMap (Insertion order): ");
        orderedVotesMap.forEach((candidate, votes) -> System.out.println(candidate + ": " + votes));
    }

    public static void displayVotesInTreeMap() {
        System.out.println("Votes in TreeMap (Sorted by votes): ");
        sortedVotesMap.forEach((candidate, votes) -> System.out.println(candidate + ": " + votes));
    }

    public static void main(String[] args) {
        addVote("Alice");
        addVote("Bob");
        addVote("Alice");
        addVote("Charlie");
        addVote("Bob");
        addVote("Alice");

        displayVotesInHashMap();
        displayVotesInLinkedHashMap();
        displayVotesInTreeMap();
    }
}
