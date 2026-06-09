class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        long bestSubarrayValue = max - min;

        return bestSubarrayValue * (long) k;
    }
}