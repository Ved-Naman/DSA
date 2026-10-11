class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int c =0;
        for(int i=1; i<= n; i++){
            if(n%i==0){
                int x= nums[i-1];
                c+=x*x;
            }
        }
        return c;
    }
}