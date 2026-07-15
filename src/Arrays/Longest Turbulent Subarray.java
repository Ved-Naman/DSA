class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }

        int maxStreak = 1;
        int currentStreak = 1;
        int lastSign = 0;

        for (int i = 1; i < arr.length; i++) {
            int currentSign = Integer.compare(arr[i], arr[i - 1]);

            if (currentSign == 0) {
                currentStreak = 1;
            } else if (currentSign == lastSign) {
                currentStreak = 2;
            } else {
                currentStreak++;
            }

            maxStreak = Math.max(maxStreak, currentStreak);
            lastSign = currentSign;
        }

        return maxStreak;
    }
}