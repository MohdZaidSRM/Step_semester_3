package String_Operations_And_Performance.class_problems;


import java.util.Arrays;

public class CSVStudentRecordParser {

    public static void parseStudentRecord(String csvLine) {
        // Edge case: Null check
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        // Split the CSV string by comma
        String[] fields = csvLine.split(",");
        System.out.println(Arrays.toString(fields));

        // Validate that exactly 3 fields are present
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        // Extract fields and clean surrounding whitespace using trim()
        String name = fields[0].trim();
        String rollNo = fields[1].trim();
        String dept = fields[2].trim();

        // Optional: Ensure none of the fields were empty (e.g., "Ananya,,CSE")
        if (name.isEmpty() || rollNo.isEmpty() || dept.isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        // Print formatted record
        System.out.println("Name: " + name + " | Roll No: " + rollNo + " | Dept: " + dept);
    }

    public static void main(String[] args) {
        // Test Cases
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
        parseStudentRecord("Ananya Verma,,CSE");
        parseStudentRecord("  Kalle Raju , RA2211003010124 , ECE ");

    }
}

