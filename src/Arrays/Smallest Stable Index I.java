class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int currentMax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            currentMax = Math.max(currentMax, nums[i]);

            int currentMin = nums[i];
            for (int j = i; j < n; j++) {
                currentMin = Math.min(currentMin, nums[j]);
            }

            if (currentMax - currentMin <= k) {
                return i;
            }
        }

        return -1;
    }
}