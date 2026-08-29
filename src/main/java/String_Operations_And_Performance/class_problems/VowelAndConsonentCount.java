package String_Operations_And_Performance.class_problems;

public class VowelAndConsonentCount {

    public static void countVowelsAndConsonants_1(String text) {
        if (text == null) {
            System.out.println("Vowels: 0 | Consonants: 0");
            return;
        }

        int vowels = 0;
        int consonants = 0;

        // Convert the entire string to lowercase once for easy comparison
        String str = text.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Process only letters (ignore spaces and punctuation)
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }


    /*
    *
    * FUNCTION countVowelsAndConsonants(text):
    IF text IS NULL THEN RETURN

    SET vowels = 0
    SET consonants = 0
    SET vowelList = "aeiouAEIOU"

    FOR EACH character 'ch' IN text.toCharArray():
        IF Character.isLetter(ch) THEN:
            IF vowelList CONTAINS ch THEN:
                INCREMENT vowels BY 1
            ELSE:
                INCREMENT consonants BY 1
            END IF
        END IF
    END FOR

    PRINT "Vowels: " + vowels + " | Consonants: " + consonants
END FUNCTION
    *
    * */
    public static void countVowelsAndConsonants_2(String text) {
        if (text == null) {
            System.out.println("Vowels: 0 | Consonants: 0");
            return;
        }

        int vowels = 0;
        int consonants = 0;
        String vowelList = "aeiouAEIOU"; // Handles case-insensitivity without changing original string

        for (char ch : text.toCharArray()) {
            // Check if the character is an alphabetic letter
            if (Character.isLetter(ch)) {
                // If indexOf returns -1, character is NOT in vowelList
                if (vowelList.indexOf(ch) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }

    public static void main(String[] args) {
        String input = "Java Programming";
        System.out.println("Input: \"" + input + "\"");
        countVowelsAndConsonants_1(input);


        System.out.println("Input: \"" + input + "\"");
        countVowelsAndConsonants_2(input);


    }
}

