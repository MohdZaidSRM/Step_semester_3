package Topic_Name.class_problems;

public class Prime_Checker {

    public static boolean isPrime(int number) {
        // Numbers less than or equal to 1 are not prime
        if (number <= 1) {
            return false;
        }

        // Check divisibility from 2 up to sqrt(number)
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false; // Found a factor, not prime
            }
        }

        return true; // No factors found, number is prime
    }

    public static void main(String[] args) {
        int[] testNumbers = {1, 2, 17, 25, 29, 49, 53, 100};

        for (int num : testNumbers) {
            if (isPrime(num)) {
                System.out.println(num + " is a Prime number.");
            } else {
                System.out.println(num + " is NOT a Prime number.");
            }
        }
    }
}
