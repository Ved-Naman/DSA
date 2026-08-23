class Solution {
    public int integerBreak(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        int pdt =1;
        while(n>4){
            pdt*= 3;
            n = n-3;
        }
        pdt*= n;
        return pdt;
    }
}