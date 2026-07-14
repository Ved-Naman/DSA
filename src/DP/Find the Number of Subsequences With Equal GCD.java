class Solution {
    int[][][] memo;
    int MOD = 1000000007;
    int[] nums;

    public int subsequencePairCount(int[] nums) {
        this.nums = nums;

        int maxVal = 0;
        for (int n : nums) {
            maxVal = Math.max(maxVal, n);
        }

        memo = new int[nums.length][maxVal + 1][maxVal + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= maxVal; j++) {
                for (int k = 0; k <= maxVal; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }

        return solve(0, 0, 0);
    }

    private int solve(int i, int gcd1, int gcd2) {
        if (i == nums.length) {
            return (gcd1 == gcd2 && gcd1 > 0) ? 1 : 0;
        }

        if (memo[i][gcd1][gcd2] != -1) {
            return memo[i][gcd1][gcd2];
        }

        long ans = 0;

        ans = (ans + solve(i + 1, gcd1, gcd2)) % MOD;

        int newGcd1 = gcd1 == 0 ? nums[i] : gcd(gcd1, nums[i]);
        ans = (ans + solve(i + 1, newGcd1, gcd2)) % MOD;

        int newGcd2 = gcd2 == 0 ? nums[i] : gcd(gcd2, nums[i]);
        ans = (ans + solve(i + 1, gcd1, newGcd2)) % MOD;

        return memo[i][gcd1][gcd2] = (int) ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}