class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;

        int[] last = new int[26];
        Arrays.fill(last, -1);

        for (int i = 1; i <= n; i++) {
            int c = s.charAt(i - 1) - 'a';

            dp[i] = (dp[i - 1] * 2) % MOD;

            if (last[c] != -1) {
                dp[i] = (dp[i] - dp[last[c] - 1]) % MOD;
            }

            if (dp[i] < 0) {
                dp[i] += MOD;
            }

            last[c] = i;
        }

        dp[n]--;
        if (dp[n] < 0) {
            dp[n] += MOD;
        }

        return dp[n];
    }
}