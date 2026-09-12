class ISBNValidator {

    static String normalizeCode(String raw) {

        raw = raw.trim();

        String firstPart = raw.substring(0, 3).toUpperCase();
        String remainingPart = raw.substring(3);

        return firstPart + remainingPart;
    }

    static String validateAndFormat(String code) {

        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }

        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < 13; i++) {

            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: code body must contain only digits";
            }
        }

        String publisher = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder result = new StringBuilder();

        result.append("[");
        result.append(publisher);
        result.append("] YEAR: ");
        result.append(year);
        result.append(" | CATALOG: ");
        result.append(catalog);

        return result.toString();
    }

    public static void main(String[] args) {

        String raw = " pen2026004251 ";

        String normalizedCode = normalizeCode(raw);

        System.out.println(validateAndFormat(normalizedCode));
    }
}