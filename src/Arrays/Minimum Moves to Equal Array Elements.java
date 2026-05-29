class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            if(num < min){
                min = num;
            }
        }
        int totalmoves = 0;
        for(int num : nums){
            totalmoves+= (num-min);
        }
        return totalmoves;
    }
}

-----------------------------------------------------------------

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
