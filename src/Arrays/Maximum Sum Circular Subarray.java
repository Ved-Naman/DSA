class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }

        int kSumMin = nums[0];
        int minSum = nums[0];

        int kSumMax = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < n; i++) {
            minSum = Math.min(nums[i] + minSum, nums[i]);
            kSumMin = Math.min(kSumMin, minSum);

            maxSum = Math.max(nums[i] + maxSum, nums[i]);
            kSumMax = Math.max(kSumMax, maxSum);
        }

        int circularSum = sum - kSumMin;

        if (kSumMax > 0) {
            return Math.max(kSumMax, circularSum);
        }

        return kSumMax;
    }
}