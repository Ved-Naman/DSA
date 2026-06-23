class Solution {
    public int zigZagArrays(int n, int l, int r) {
        if (n == 1) return r - l + 1;

        int m = r - l + 1;
        int MOD = 1_000_000_007;

        int[] dp = new int[m + 1];

        for (int v = 1; v <= m; v++) {
            dp[v] = 1;
        }

        for (int i = 2; i <= n; i++) {
            int[] nextDp = new int[m + 1];

            if (i % 2 == 0) {
                int runningSum = 0;
                for (int v = 2; v <= m; v++) {
                    runningSum = (runningSum + dp[v - 1]) % MOD;
                    nextDp[v] = runningSum;
                }
            }
            else {
                int runningSum = 0;
                for (int v = m - 1; v >= 1; v--) {
                    runningSum = (runningSum + dp[v + 1]) % MOD;
                    nextDp[v] = runningSum;
                }
            }

            dp = nextDp;
        }

        long totalWays = 0;
        for (int v = 1; v <= m; v++) {
            totalWays = (totalWays + dp[v]) % MOD;
        }

        return (int) ((totalWays * 2) % MOD);
    }
}