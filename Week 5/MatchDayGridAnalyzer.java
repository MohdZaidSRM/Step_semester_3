public class MatchDayGridAnalyzer {
    public static void main(String[] args) {
        int[][] runsPerOver = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        int threshold = 8;
        String result = classifyMatches(runsPerOver, threshold);
        System.out.println(result);
    }

    // Calculates average of a single row
    static double rowAverage(int[] row) {
        int sum = 0;
        for (int val : row) sum += val;
        return (double) sum / row.length;
    }

    // Classifies each match based on average runs per over
    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            sb.append("Match ").append(i).append(": ");
            sb.append(avg >= threshold ? "Power Surge" : "Normal");
            if (i < runsPerOver.length - 1) sb.append(" | ");
        }
        return sb.toString();
    }
}
