class Solution {
    public long findKthSmallest(int[] coins, int k) {
        Arrays.sort(coins);

        long left = 1;
        long right = (long) coins[0] * k;
        long ans = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (countMultiples(mid, coins) >= k) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private long countMultiples(long mid, int[] coins) {
        int n = coins.length;
        long totalCount = 0;

        for (int i = 1; i < (1 << n); i++) {
            long lcm = 1;
            int countSetBits = 0;

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    lcm = getLCM(lcm, coins[j]);
                    countSetBits++;

                    if (lcm > mid) break;
                }
            }

            if (lcm > mid) continue;

            if (countSetBits % 2 == 1) {
                totalCount += (mid / lcm);
            } else {
                totalCount -= (mid / lcm);
            }
        }

        return totalCount;
    }

    private long getGCD(long a, long b) {
        return b == 0 ? a : getGCD(b, a % b);
    }

    private long getLCM(long a, long b) {
        return (a / getGCD(a, b)) * b;
    }
}