class Solution {
    public int majorityElement(int[] nums) {
        int max = 1;
        int count = 1;
        int majority = nums[0];
        Arrays.sort(nums);
        for(int i = 1; i< nums.length; i++){
            if(nums[i]==nums[i-1]){
                count++;

            }else{
                count = 1;
            }
            if(count>max){
                max = count;
                majority = nums[i];
            }
        }
        return majority;
    }
}