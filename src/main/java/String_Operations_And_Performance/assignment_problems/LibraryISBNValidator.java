package String_Operations_And_Performance.assignment_problems;

public class LibraryISBNValidator {

    public static String normalizeCode(String raw) {
        if (raw == null) return "";
        String trimmed = raw.trim();

        if (trimmed.length() < 3) {
            return trimmed;
        }

        // Uppercase first 3 characters and keep the rest intact
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String code) {
        if (code == null || code.length() != 13) {
            return "Invalid: wrong length";
        }

        // First 3 characters must be letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Remaining 10 characters must be digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        // Extract segments: 3 publisher letters, 4-digit year, 6-digit catalog
        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] YEAR: ").append(year);
        sb.append(" | CATALOG: ").append(catalog);

        return sb.toString();
    }

    public static void main(String[] args) {
        String test1 = normalizeCode(" pen2026004251 ");
        System.out.println(validateAndFormat(test1)); // Output: [PEN] YEAR: 2026 | CATALOG: 004251

        String test2 = normalizeCode("12N2026004251");
        System.out.println(validateAndFormat(test2)); // Output: Invalid: publisher code must be 3 letters
    }
}
