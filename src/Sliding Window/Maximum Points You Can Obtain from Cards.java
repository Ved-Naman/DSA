class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int left = 0;
        int right = 0;
        int max = 0;
        for(int i = 0; i< k ; i++){
            left+=cardPoints[i];
        }
        max = left;
        int r = n-1;
        for(int i = k-1;i>=0; i--){
            left -= cardPoints[i];

            // Add a card from the very end of the array
            right += cardPoints[r];

            // Check if this new combination beats our previous maximum
            max = Math.max(max, left + right);

            // Move our right index inward for the next loop
            r--;
        }
        return max;
    }
}