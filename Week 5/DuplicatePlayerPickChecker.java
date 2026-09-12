public class DuplicatePlayerPickChecker {
    public static void main(String[] args) {
        String[] players = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        String result = findDuplicatePick(players);
        System.out.println(result);
    }

    // Returns first duplicate or a not‑found message
    static String findDuplicatePick(String[] playerNames) {
        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }
}
