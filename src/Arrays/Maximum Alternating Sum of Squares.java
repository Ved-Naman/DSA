class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] squares = new long[n];

        // Step 1: Square each element (use long to prevent overflow)
        for (int i = 0; i < n; i++) {
            long val = nums[i];
            squares[i] = val * val;
        }

        // Step 2: Sort the squares in ascending order
        Arrays.sort(squares);

        // Step 3: Count how many elements need to be subtracted
        int negativeCount = n / 2;
        long score = 0;

        // Step 4: Subtract the smallest squares, add the rest
        for (int i = 0; i < n; i++) {
            if (i < negativeCount) {
                score -= squares[i];
            } else {
                score += squares[i];
            }
        }

        return score;
    }
}