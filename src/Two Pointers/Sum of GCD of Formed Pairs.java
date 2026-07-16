class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
        int currMax = 0;
        for(int i =0; i< n; i++){
            currMax = Math.max(currMax, nums[i]);
            prefixGcd[i] = Gcd(nums[i],currMax);
        }
        Arrays.sort(prefixGcd);
        long sum =0;
        int left = 0;
        int right = n-1;
        while(left<right){
            sum+= Gcd(prefixGcd[left],prefixGcd[right]);
            left++;
            right--;
        }
        return sum;
    }
    private int Gcd(int a, int b){
        while(b!=0){
            int temp = a%b;
            a=b;
            b=temp;
        }
        return a;
    }
}