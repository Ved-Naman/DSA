class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int min = nums[0];
        int totalmoves = 0;
        for(int num : nums){
            totalmoves+= (num-min);
        }
        return totalmoves;
    }
}