package Java_String_Concepts.class_problems;

public class PalindromeChecker {
    public static boolean isPalindromeIterative(String text) {
        int left = 0;                  // Pointer starting at the first character
        int right = text.length() - 1; // Pointer starting at the last character

        // Keep moving inward until pointers meet in the middle
        while (left < right) {
            // Mismatch found -> exit early! Not a palindrome
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;  // Move left pointer inward
            right--; // Move right pointer inward
        }

        // No mismatches found
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        // Base Case: empty string or single character is always a palindrome
        if (text.length() <= 1) {
            return true;
        }

        char firstChar = text.charAt(0);
        char lastChar = text.charAt(text.length() - 1);

        // If outer characters don't match, stop immediately
        if (firstChar != lastChar) {
            return false;
        }

        // Recursive Step: strip outer characters and check inner substring
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();                // String -> character array
        char[] reversed = new char[original.length];        // Empty array to hold reverse

        // Copy characters from the end of original into the start of reversed
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        // Convert reversed array back to String and compare with original
        return text.equals(new String(reversed));
    }

    // =========================================================================
    // MAIN METHOD (Demo Execution)
    // =========================================================================
    public static void main(String[] args) {
        String[] testWords = {"madam", "hello", "racecar", "java"};

        System.out.println("=== PALINDROME CHECKER RESULTS ===");
        System.out.println("----------------------------------------------");

        for (String word : testWords) {
            System.out.println("Input Word: \"" + word + "\"");
            System.out.println(" -> Approach 1 (Iterative)  : " + (isPalindromeIterative(word) ? "Palindrome" : "Not Palindrome"));
            System.out.println(" -> Approach 2 (Recursive)  : " + (isPalindromeRecursive(word) ? "Palindrome" : "Not Palindrome"));
            System.out.println(" -> Approach 3 (Reversal)   : " + (isPalindromeArrayReversal(word) ? "Palindrome" : "Not Palindrome"));
            System.out.println("----------------------------------------------");
        }
    }
}