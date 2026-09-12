class TrafficSignalAnalyzer {

    static void findLongestStreak(String signalLog) {

        int currentCount = 1;
        int maxCount = 1;

        char currentColor = signalLog.charAt(0);
        char longestColor = signalLog.charAt(0);

        for (int i = 1; i < signalLog.length(); i++) {

            if (signalLog.charAt(i) == currentColor) {
                currentCount++;
            } else {
                currentColor = signalLog.charAt(i);
                currentCount = 1;
            }

            if (currentCount > maxCount) {
                maxCount = currentCount;
                longestColor = currentColor;
            }
        }

        System.out.println("Longest Streak: '" +
                longestColor + "' repeated " +
                maxCount + " times");
    }

    public static void main(String[] args) {
        String signalLog = "RRGGGYRR";

        findLongestStreak(signalLog);
    }
}