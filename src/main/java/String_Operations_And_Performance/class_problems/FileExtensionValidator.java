package String_Operations_And_Performance.class_problems;

public class FileExtensionValidator {

    public static String validateFileExtension(String filename) {
        // Edge case: Null or empty string check
        if (filename == null || filename.trim().isEmpty()) {
            return "Rejected — invalid file type";
        }

        // Find the index of the last dot
        int lastDotIndex = filename.lastIndexOf('.');

        // Edge case: No dot found OR dot is the last character (e.g., "filename.")
        if (lastDotIndex == -1 || lastDotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        // Extract the extension after the last dot
        String extension = filename.substring(lastDotIndex + 1);

        // Case-insensitive comparison against allowed extensions
        if (extension.equalsIgnoreCase("pdf") ||
                extension.equalsIgnoreCase("img") ||
                extension.equalsIgnoreCase("jpg")) {
            return "Accepted";
        }

        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        // Sample Tests
        System.out.println("Assignment1.PDF -> " + validateFileExtension("Assignment1.PDF"));
        System.out.println("notes.txt      -> " + validateFileExtension("notes.txt"));
        System.out.println("project.v2.zip -> " + validateFileExtension("project.v2.zip"));
        System.out.println("noextension    -> " + validateFileExtension("noextension"));
    }
}
