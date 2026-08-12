class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int maxLen = 0;
        int left = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];
            freq.put(num, freq.getOrDefault(num, 0) + 1);

            while (freq.get(num) > k) {
                int leftNum = nums[left];
                freq.put(leftNum, freq.get(leftNum) - 1);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}