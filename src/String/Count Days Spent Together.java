class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        // Convert all four dates to day-of-the-year integers
        int arriveAliceDay = convertToDayOfYear(arriveAlice);
        int leaveAliceDay = convertToDayOfYear(leaveAlice);
        int arriveBobDay = convertToDayOfYear(arriveBob);
        int leaveBobDay = convertToDayOfYear(leaveBob);

        // Find the overlap range
        int overlapStart = Math.max(arriveAliceDay, arriveBobDay);
        int overlapEnd = Math.min(leaveAliceDay, leaveBobDay);

        // Calculate total days spent together (inclusive)
        return Math.max(0, overlapEnd - overlapStart + 1);
    }

    private int convertToDayOfYear(String dateStr) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int month = Integer.parseInt(dateStr.substring(0, 2));
        int day = Integer.parseInt(dateStr.substring(3, 5));

        int totalDays = day;
        for (int i = 0; i < month - 1; i++) {
            totalDays += daysInMonth[i];
        }

        return totalDays;
    }
}