class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<=2){
            return 0;
        }
        int x = 0;
        int y = 0;
        for(int i = 2; i<nums.length; i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                x++;
                y+=x;
            }else{
                x=0;
            }
        }
        return y;
    }
}