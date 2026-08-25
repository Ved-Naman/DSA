class Solution {
    public int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int[] clone = nums.clone();
        Arrays.sort(clone);

        int max = clone[clone.length - 1];
        int secondMax = clone[clone.length - 2];

        if (max >= secondMax * 2) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == max) {
                    return i;
                }
            }
        }

        return -1;
    }
}