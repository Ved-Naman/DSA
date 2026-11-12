class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int max = 1;
        int x = 1;
        int dec = 1;
        for(int i =1; i<nums.length; i++){
            if(nums[i]>nums[i-1]){
                x++;
                dec = 1;
            }else if(nums[i]<nums[i-1]){
                dec++;
                x = 1;
            }else{
                x = 1;
                dec = 1;
            }
            max = Math.max(max,Math.max(x,dec));
        }
        return max;
    }
}