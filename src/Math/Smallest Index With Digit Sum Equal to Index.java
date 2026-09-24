class Solution {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int current = nums[i];

            while (current > 0) {
                sum += current % 10;
                current /= 10;
            }

            if (sum == i) {
                return i;
            }
        }

        return -1;
    }
}