class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int maxDiff = 0;
        int[] diff = new int[n];
        long totalDiffSum = 0;

        // Step 1: Calculate absolute differences and total sum
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
            totalDiffSum += diff[i];
        }

        long k = (long) k1 + k2;

        // If total budget can cover all differences, the minimum sum is 0
        if (totalDiffSum <= k) {
            return 0;
        }

        // Step 2: Frequency array to count occurrences of each difference
        int[] count = new int[maxDiff + 1];
        for (int d : diff) {
            count[d]++;
        }

        // Step 3: Greedily reduce the largest differences using the budget k
        for (int i = maxDiff; i > 0 && k > 0; i--) {
            if (count[i] == 0) continue;
            long reduceCount = Math.min(k, count[i]);
            count[i] -= reduceCount;
            count[i - 1] += (int) reduceCount;
            k -= reduceCount;
        }

        // Step 4: Calculate the final minimum sum of squared differences
        long result = 0;
        for (int i = 0; i <= maxDiff; i++) {
            if (count[i] > 0) {
                result += (long) count[i] * i * i;
            }
        }

        return result;
    }
}