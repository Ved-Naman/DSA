class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = nums[n-1];
        int moves = 0;
        for(int m : nums){
            moves += max - m;
        }
        return moves;
    }
}