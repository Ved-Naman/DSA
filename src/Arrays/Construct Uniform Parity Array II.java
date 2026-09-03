class Solution {
    public boolean uniformArray(int[] nums) {
        int minOdd = Integer.MAX_VALUE;

        // Pass 1: Find the smallest odd number
        for (int num : nums) {
            if (num % 2 != 0) {
                minOdd = Math.min(minOdd, num);
            }
        }

        // If there are no odd numbers, it's already all even!
        if (minOdd == Integer.MAX_VALUE) {
            return true;
        }

        // Pass 2: Check if any even number is trapped
        for (int num : nums) {
            if (num % 2 == 0 && num < minOdd) {
                return false;
            }
        }

        return true;
    }
}