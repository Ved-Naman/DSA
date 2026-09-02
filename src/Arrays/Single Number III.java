class Solution {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        int index = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] == nums[i+1]) {
                i++;
            } else {
                result[index] = nums[i];
                index++;
            }
        }
        return result;
    }
}