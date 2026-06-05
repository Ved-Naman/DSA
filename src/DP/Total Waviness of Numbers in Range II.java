class Solution {
    long[][][][][] sumDp;
    long[][][][][] countDp;
    boolean[][][][][] visited;
    String maxStr;

    public long totalWaviness(long num1, long num2) {
        // Find the waviness from 1 to num2, and subtract the waviness from 1 to num1-1
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long n) {
        if (n < 0) return 0;

        maxStr = Long.toString(n);
        int len = maxStr.length();

        // DP dimensions: [index][prev2][prev1][isLimit][isLeadingZero]
        // We use '11' for prev variables because '10' represents an empty/non-existent digit
        sumDp = new long[len][11][11][2][2];
        countDp = new long[len][11][11][2][2];
        visited = new boolean[len][11][11][2][2];

        // Start at index 0, with empty history (10), bounded by limit (1), and in leading zeros (1)
        return dfs(0, 10, 10, 1, 1)[1]; // Index 1 holds the total sum
    }

    // Returns an array of two values: { totalCount, totalWavinessSum }
    private long[] dfs(int idx, int prev2, int prev1, int isLimit, int isLz) {

        // Base Case: We successfully built a number! It counts as 1 combination with 0 new waves.
        if (idx == maxStr.length()) {
            return new long[]{1, 0};
        }

        // If we have already calculated this exact scenario, return our cached result
        if (visited[idx][prev2][prev1][isLimit][isLz]) {
            return new long[]{countDp[idx][prev2][prev1][isLimit][isLz], sumDp[idx][prev2][prev1][isLimit][isLz]};
        }

        // What is the highest digit we are allowed to place right now?
        int limit = (isLimit == 1) ? (maxStr.charAt(idx) - '0') : 9;

        long totalCount = 0;
        long totalSum = 0;

        // Try placing every digit from 0 up to our calculated limit
        for (int d = 0; d <= limit; d++) {

            // Calculate the boolean flags for the next recursive step
            int nLimit = (isLimit == 1 && d == limit) ? 1 : 0;
            int nLz = (isLz == 1 && d == 0) ? 1 : 0;

            // If we are still in leading zeros, history is empty (10). 
            // Otherwise, shift the history backwards.
            int nPrev2 = (isLz == 1) ? 10 : prev1;
            int nPrev1 = (nLz == 1) ? 10 : d;

            long wave = 0;

            // Check if we just formed a peak or a valley! 
            // (We must ensure we are not working with empty placeholders or leading zeros)
            if (prev2 != 10 && prev1 != 10 && nLz == 0) {
                boolean isPeak = (prev2 < prev1 && d < prev1);
                boolean isValley = (prev2 > prev1 && d > prev1);

                if (isPeak || isValley) {
                    wave = 1;
                }
            }

            // Dive deeper into the next digit
            long[] sub = dfs(idx + 1, nPrev2, nPrev1, nLimit, nLz);

            // Accumulate the combinations and sum!
            totalCount += sub[0];
            totalSum += sub[1] + (sub[0] * wave);
        }

        // Save our hard work to the cache so we don't have to calculate it again
        visited[idx][prev2][prev1][isLimit][isLz] = true;
        countDp[idx][prev2][prev1][isLimit][isLz] = totalCount;
        sumDp[idx][prev2][prev1][isLimit][isLz] = totalSum;

        return new long[]{totalCount, totalSum};
    }
}