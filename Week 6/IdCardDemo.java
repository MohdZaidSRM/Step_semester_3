public class IdCardDemo {
    // Simple class representing a library ID card
    static class IdCard {
        String name;
        int booksIssued;

        public IdCard(String name, int booksIssued) {
            this.name = name;
            this.booksIssued = booksIssued;
        }
    }

    public static void main(String[] args) {
        // First reference
        IdCard ravi = new IdCard("Ravi", 0);
        // Second variable points to same object
        IdCard duplicate = ravi;
        duplicate.booksIssued = 3;
        // Third separate object with same field values
        IdCard separate = new IdCard("Ravi", 3);

        System.out.println(ravi.name + "'s booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}
