class Solution {
    public int minElement(int[] nums) {
        int minOverall = Integer.MAX_VALUE;
        for (int num : nums) {
            int currentSum = 0;

            while (num > 0) {
                currentSum += num % 10; // Grab the last digit
                num /= 10;              // Chop off the last digit
            }

            if (currentSum < minOverall) {
                minOverall = currentSum;
            }
        }

        return minOverall;
    }
}