class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] pairs = new int[n][2];

        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        int[] result = new int[n];
        int i = 0;

        while (i < n) {
            int start = i;
            i++;

            while (i < n && pairs[i][0] - pairs[i - 1][0] <= limit) {
                i++;
            }

            int groupSize = i - start;
            int[] indices = new int[groupSize];

            for (int j = 0; j < groupSize; j++) {
                indices[j] = pairs[start + j][1];
            }

            Arrays.sort(indices);

            for (int j = 0; j < groupSize; j++) {
                result[indices[j]] = pairs[start + j][0];
            }
        }

        return result;
    }
}