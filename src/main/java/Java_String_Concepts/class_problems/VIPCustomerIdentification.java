package Java_String_Concepts.class_problems;


public class VIPCustomerIdentification {
    // Checks whether a customer ID follows the "VIP-" naming convention
    public static String validateCustomerId(String customerId) {
        // startsWith() checks the beginning of the string for an exact match
        if (customerId.startsWith("VIP-")) {
            return "VIP Customer"; // prefix matched -> this is a VIP account
        }
        return "Regular Customer"; // prefix didn't match -> treat as a regular account
    }

    public static void main(String[] args) {
        // Two sample IDs: one VIP, one regular
        String[] customerIds = {"VIP-4589", "CUS-4589"};
        // Validate each ID and print the result
        for (String id : customerIds) {
            String status = validateCustomerId(id);
            System.out.println("Input: \"" + id + "\" -> Output: " + status);
        }
    }
}
