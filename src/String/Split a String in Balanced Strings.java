class Solution {
    public int balancedStringSplit(String s) {
        int ans = 0;
        int l = 0;
        int r = 0;
        for(int i= 0; i< s.length(); i++){
            if(s.charAt(i)=='R'){
                r++;
            }else{
                l++;
            }
            if(r==l){
                r=0;
                l=0;
                ans++;
            }
        }
        return ans;
    }
}