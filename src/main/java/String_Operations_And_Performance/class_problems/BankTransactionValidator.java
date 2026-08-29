package String_Operations_And_Performance.class_problems;

public class BankTransactionValidator {

    public static String normalizeReference(String raw) {
        if (raw == null) return "";

        // Trim leading and trailing whitespace
        String trimmed = raw.trim();

        // Need at least 3 characters to upper-case the bank code safely
        if (trimmed.length() < 3) {
            return trimmed;
        }

        // Uppercase first 3 characters and concatenate remaining string
        String bankCodeUpper = trimmed.substring(0, 3).toUpperCase();
        String restOfCode = trimmed.substring(3);

        return bankCodeUpper + restOfCode;
    }

    public static String validateAndFormat(String reference) {
        if (reference == null || reference.length() != 14) {
            return "Invalid: wrong length";
        }

        // 1. Validate first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // 2. Validate remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        // 3. Extraction for formatting:
        // Index 0 to 3: Bank Code (3 chars)
        // Index 3 to 9: Date ddMMyy (6 chars) -> dd=3..5, MM=5..7, yy=7..9
        // Index 9 to 14: Sequence Number (5 chars)
        String bankCode = reference.substring(0, 3);
        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);
        String sequence = reference.substring(9, 14);

        // Build formatted display line using StringBuilder
        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(bankCode).append("] ");
        formatted.append("DATE: ").append(day).append("/").append(month).append("/").append(year);
        formatted.append(" | SEQ: ").append(sequence);

        return formatted.toString();
    }

    public static void main(String[] args) {
        String[] testInputs = {" hdf03022600042 ",   // Valid
                "12F03022600042",     // Bad bank code
                "hdf030226000A2",     // Bad body digit
                "hdf030226"           // Wrong length
        };

        for (String rawInput : testInputs) {
            String normalized = normalizeReference(rawInput);
            String result = validateAndFormat(normalized);
            System.out.println("Input: \"" + rawInput + "\" -> Output: " + result);
        }
    }
}

