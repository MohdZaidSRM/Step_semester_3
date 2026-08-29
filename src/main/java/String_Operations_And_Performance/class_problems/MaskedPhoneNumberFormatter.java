package String_Operations_And_Performance.class_problems;


public class MaskedPhoneNumberFormatter {

    public static String maskPhoneNumber(String phone) {
        // Validation 1: Check null or length not equal to 10
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        // Validation 2: Ensure all characters are numeric digits
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        // Extract last 4 digits
        String lastFourDigits = phone.substring(6);

        // Build masked string using StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX");
        sb.append("-");
        sb.append(lastFourDigits);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("9876543210 -> " + maskPhoneNumber("9876543210"));
        System.out.println("98765      -> " + maskPhoneNumber("98765"));
        System.out.println("98765A3210 -> " + maskPhoneNumber("98765A3210"));
    }
}

