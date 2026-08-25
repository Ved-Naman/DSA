class Solution {
    public int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);

        int target = k;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                target += k;
            }
        }

        return target;
    }
}