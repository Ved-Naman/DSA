class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] x = new int[nums.length];
        int[] y = new int[nums.length];
        int j=0;
        int k=0;
        for(int i = 0; i< nums.length; i++){
            if(nums[i]%2==0){
                x[j]=nums[i];
                j++;
            }else{
                y[k]=nums[i];
                k++;
            }
        }
        int[] result = new int[nums.length];

        for (int i = 0; i < j; i++) {
            result[i] = x[i];
        }

        for (int i = 0; i <k; i++) {
            result[j + i] = y[i];
        }
        return result;
    }
}