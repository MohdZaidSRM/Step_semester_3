package Java_String_Concepts.class_problems;

public class findFirstNonRepeatingChar_Class {

    public static Character findFirstNonRepeatingChar(String text) {
        // ASCII size is 256
        int[] frequency = new int[256];

        // Pass 1: Count occurrences of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }

        // Pass 2: Find the FIRST character with a frequency of 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (frequency[ch] == 1) {
                return ch; // Found the first non-repeating character!
            }
        }

        return null; // No unique character found
    }

    public static void main(String[] args) {
        // One word with a unique character, one word where every letter repeats
        String[] testWords = {"swiss", "aabbcc"};
        for (String word : testWords) {
            Character result = findFirstNonRepeatingChar(word);
            if (result != null) {
                System.out.println("Input: \"" + word + "\" -> First Non-Repeating Character: '" + result + "'");
            } else {
                System.out.println("Input: \"" + word + "\" -> No Non-Repeating Character Found");
            }
        }
    }
}
