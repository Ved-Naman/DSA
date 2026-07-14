class Solution {
    public int rob(int[] nums) {
        int total = 0;
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int prevprev= 0;
        int prev=0;
        for(int i = 0;i< nums.length; i++){
            int current = Math.max(nums[i]+prevprev, prev);
            prevprev=prev;
            prev=current;
        }
        return prev;
    }
}