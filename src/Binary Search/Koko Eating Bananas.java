class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int bestSpeed = right;
        while (left <= right) {
            int k = left + (right - left) / 2;

            long totalHours = 0;
            for (int pile : piles) {
                // Math.ceil rounds up. E.g., 7 bananas at speed 3 = 3 hours.
                totalHours += Math.ceil((double) pile / k);
            }

            if (totalHours <= h) {
                bestSpeed = k;
                right = k - 1;
            } else {
                left = k + 1;
            }
        }

        return bestSpeed;
    }
}