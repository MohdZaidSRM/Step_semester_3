package String_Operations_And_Performance.assignment_problems;

import java.util.*;

public class WordFrequencyReport {

    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            return;
        }

        // Fixed stop words to ignore
        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "was", "and", "a", "is", "of", "in"));

        // Clean text: lowercase and remove periods and commas
        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "");

        // Split by one or more whitespace characters
        String[] words = cleaned.trim().split("\\s+");

        // Count frequency of non-stop words
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            if (!stopWords.contains(word) && !word.isEmpty()) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }

        // Convert map entries to list and sort by count descending
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        entryList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Print word frequencies
        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String sampleFeedback = "The mentor was great, the session was great and clear.";
        printFilteredWordFrequency(sampleFeedback);
    }
}
