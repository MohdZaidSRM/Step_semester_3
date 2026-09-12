import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class WordFrequency {

    static void printFilteredWordFrequency(String feedback) {

        String[] stopWords = {
            "the", "was", "and", "a", "is", "of", "in"
        };

        feedback = feedback.toLowerCase();

        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");

        String[] words = feedback.split("\\s+");

        HashMap<String, Integer> frequency = new HashMap<>();

        for (int i = 0; i < words.length; i++) {

            boolean isStopWord = false;

            for (int j = 0; j < stopWords.length; j++) {

                if (words[i].equals(stopWords[j])) {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord) {

                if (frequency.containsKey(words[i])) {

                    frequency.put(
                        words[i],
                        frequency.get(words[i]) + 1
                    );

                } else {

                    frequency.put(words[i], 1);
                }
            }
        }

        ArrayList<String> wordList =
                new ArrayList<>(frequency.keySet());

        Collections.sort(wordList, new Comparator<String>() {

            public int compare(String a, String b) {
                return frequency.get(b) - frequency.get(a);
            }
        });

        for (String word : wordList) {

            System.out.println(
                word + ": " + frequency.get(word)
            );
        }
    }

    public static void main(String[] args) {

        String feedback =
                "The mentor was great, the session was great and clear.";

        printFilteredWordFrequency(feedback);
    }
}