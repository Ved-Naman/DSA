import java.util.Arrays;

class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        // Only need to cross off multiples starting from p * p up to sqrt(n)
        for (int p = 2; (long) p * p < n; p++) {
            if (isPrime[p]) {
                for (int multiple = p * p; multiple < n; multiple += p) {
                    isPrime[multiple] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }
}