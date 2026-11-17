class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                cost[i][j] = getMinCost(s, i - 1, j - 1);
            }
        }

        int[][] dp = new int[k + 1][n + 1];
        for (int i = 0; i <= k; i++) {
            java.util.Arrays.fill(dp[i], 1000000);
        }
        dp[0][0] = 0;

        for (int p = 1; p <= k; p++) {
            for (int i = p * 2; i <= n; i++) {
                for (int j = (p - 1) * 2; j <= i - 2; j++) {
                    dp[p][i] = Math.min(dp[p][i], dp[p - 1][j] + cost[j + 1][i]);
                }
            }
        }

        return dp[k][n];
    }

    private int getMinCost(String s, int start, int end) {
        int len = end - start + 1;
        if (len == 1) return 1000000;
        int minChanges = len;

        for (int d = 1; d < len; d++) {
            if (len % d != 0) continue;
            int currentCost = 0;
            for (int group = 0; group < d; group++) {
                int l = start + group;
                int r = start + len - d + group;
                while (l < r) {
                    if (s.charAt(l) != s.charAt(r)) {
                        currentCost++;
                    }
                    l += d;
                    r -= d;
                }
            }
            minChanges = Math.min(minChanges, currentCost);
        }

        return minChanges;
    }
}