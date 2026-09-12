public class FantasyTeamScoreMultiplier {
    public static void main(String[] args) {
        double[] scores = {40, 55, 30, 62};
        applyMultipliers(scores, 1, 3);
        // Print result
        System.out.print("[");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i]);
            if (i < scores.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // Multiplies captain and vice‑captain scores directly in the array
    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] *= 2.0;          // captain x2
        playerScores[viceCaptainIndex] *= 1.5;     // vice‑captain x1.5
    }
}
