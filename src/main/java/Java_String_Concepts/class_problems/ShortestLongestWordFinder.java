package Java_String_Concepts.class_problems;

public class ShortestLongestWordFinder {

    // Finds the shortest and the longest word in a block of text
    public static String[] findShortestAndLongestWord(String text) {
        // Validation check for empty or null strings
        if (text == null || text.trim().isEmpty()) {
            return new String[]{"", ""};
        }

        // trim() removes leading/trailing spaces
        // split("\\s+") breaks on any run of one or more whitespace characters
        String[] words = text.trim().split(" ");

        // Assume the very first word is both the shortest and the longest baseline
        String shortest = words[0];
        String longest = words[0];

        // Compare every remaining word against current shortest/longest
        for (int i = 1; i < words.length; i++) {

            String currentWord = words[i];
            if (currentWord.length() < 1) {
                continue;
            }
            // Found a shorter word -> update shortest
            if (currentWord.length() < shortest.length()) {
                shortest = currentWord;
            }

            // Found a longer word -> update longest
            if (currentWord.length() > longest.length()) {
                longest = currentWord;
            }
        }

        // Return both results in a two-element array: [shortest, longest]
        return new String[]{shortest, longest};
    }

    public static void main(String[] args) {
        // Sample sentence to analyze
        String sentence = "Java     is     i  an    object    oriented    programming    language";

        // Unpack the two-element array result
        String[] result = findShortestAndLongestWord(sentence);
        String shortestWord = result[0];
        String longestWord = result[1];

        // Output the results with character counts
        System.out.println("Input Sentence: \"" + sentence + "\"");
        System.out.println("----------------------------------------------");
        System.out.println("Shortest Word : \"" + shortestWord + "\" (" + shortestWord.length() + " chars)");
        System.out.println("Longest Word  : \"" + longestWord + "\" (" + longestWord.length() + " chars)");
    }
}
