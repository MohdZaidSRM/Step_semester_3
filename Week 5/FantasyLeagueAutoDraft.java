public class FantasyLeagueAutoDraft {
    // Player class with Comparable implementation for sorting by battingAverage descending
    public static class Player implements Comparable<Player> {
        String name;
        int matchesPlayed;
        double battingAverage;
        boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        @Override
        public int compareTo(Player other) {
            // Descending order of battingAverage
            return Double.compare(other.battingAverage, this.battingAverage);
        }
    }

    // Overloaded draftability checks
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        if (matchesPlayed >= 10) {
            return true; // injury ignored for >=10 matches
        }
        return matchesPlayed >= 5 && !injured;
    }

    // Returns a formatted ranking of draftable players sorted by battingAverage descending
    static String draftAndRank(Player[] players) {
        java.util.List<Player> draftable = new java.util.ArrayList<>();
        for (Player p : players) {
            if (isDraftable(p.matchesPlayed, p.injured)) {
                draftable.add(p);
            }
        }
        // Sort using Comparable (battingAverage descending)
        java.util.Collections.sort(draftable);
        // Build ranking string like "1. Rahul | 2. Virat | 3. Dev"
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftable.size(); i++) {
            sb.append(i + 1).append(". ").append(draftable.get(i).name);
            if (i < draftable.size() - 1) sb.append(" | ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };
        String ranking = draftAndRank(players);
        System.out.println(ranking);
    }
}
