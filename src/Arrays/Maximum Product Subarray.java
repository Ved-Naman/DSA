class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int maxP = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int currentProduct = 1;

            for (int j = i; j < nums.length; j++) {
                currentProduct *= nums[j];
                maxP = Math.max(maxP, currentProduct);
            }
        }

        return maxP;
    }
}