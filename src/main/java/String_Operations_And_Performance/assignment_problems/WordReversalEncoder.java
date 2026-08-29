package String_Operations_And_Performance.assignment_problems;

public class WordReversalEncoder {

    public static String reverseEachWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return "";
        }

        // Split sentence into words by single space
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder wordBuilder = new StringBuilder(words[i]);
            result.append(wordBuilder.reverse());

            // Add space between words, but not after the last word
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "hello club";
        String output = reverseEachWord(input);
        System.out.println(output); // Output: olleh bulc
    }
}
