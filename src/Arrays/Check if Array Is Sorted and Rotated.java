class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int[] B = nums.clone();
        Arrays.sort(B);
        for(int x = 0; x< n ; x++){
            boolean ans = true;
            for(int i= 0; i<n; i++){
                if(B[i]!=nums[(i+x)%n]){
                    ans = false;
                    break;
                }
            }
            if(ans){
                return true;
            }
        }
        return false;
    }
}