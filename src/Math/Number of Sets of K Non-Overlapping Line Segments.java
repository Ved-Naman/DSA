class Solution {
    public int numberOfSets(int n, int k) {
        int N = n + k - 1;
        int K = 2 * k;

        if (K > N) return 0;

        long MOD = 1000000007;
        long res = 1;

        // Calculate nCr = N! / (K! * (N-K)!) using modular arithmetic
        K = Math.min(K, N - K);
        for (int i = 1; i <= K; i++) {
            res = (res * (N - i + 1)) % MOD;
            res = (res * modInverse(i, MOD)) % MOD;
        }

        return (int) res;
    }

    // Fermat's Little Theorem for modular division
    private long modInverse(long a, long m) {
        return power(a, m - 2, m);
    }

    private long power(long base, long exp, long mod) {
        long res = 1;
        base = base % mod;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % mod;
            exp = exp >> 1;
            base = (base * base) % mod;
        }
        return res;
    }
}