class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] prev = new long[k];

        for (int num : nums) {
            long[] curr = new long[k];
            int val = num % k;

            curr[val]++;

            for (int y = 0; y < k; y++) {
                if (prev[y] > 0) {
                    int nextRem = (int) (((long) y * val) % k);
                    curr[nextRem] += prev[y];
                }
            }

            for (int x = 0; x < k; x++) {
                result[x] += curr[x];
                prev[x] = curr[x];
            }
        }

        return result;
    }
}