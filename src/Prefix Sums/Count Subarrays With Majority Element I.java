class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int[] freq = new int[2 * n + 1];

        int currentSum = 0;
        int smallerCount = 0;
        int totalSubarrays = 0;

        freq[n] = 1;

        for (int num : nums) {
            if (num == target) {
                smallerCount += freq[currentSum + n];
                currentSum++;
            } else {
                smallerCount -= freq[currentSum - 1 + n];
                currentSum--;
            }

            totalSubarrays += smallerCount;
            freq[currentSum + n]++;
        }

        return totalSubarrays;
    }
}