class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] doublenums = new int[2*n];
        for(int i =0; i< n; i++){
            doublenums[i]=nums[i];
            doublenums[i+n]= nums[i];

        }
        for(int i =0; i<n; i++){
            result[i]= -1;
            for(int j=i+1;j<doublenums.length;j++){
                if(doublenums[j]>nums[i]){
                    result[i]=doublenums[j];
                    break;
                }
            }
        }
        return result;
    }
}