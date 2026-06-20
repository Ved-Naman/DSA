class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        int m = restrictions.length;
        int[][] res = new int[m + 2][2];

        for (int i = 0; i < m; i++) {
            res[i] = restrictions[i];
        }

        res[m] = new int[]{1, 0};
        res[m + 1] = new int[]{n, n - 1};

        Arrays.sort(res, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 1; i < res.length; i++) {
            int distance = res[i][0] - res[i - 1][0];
            res[i][1] = Math.min(res[i][1], res[i - 1][1] + distance);
        }

        for (int i = res.length - 2; i >= 0; i--) {
            int distance = res[i + 1][0] - res[i][0];
            res[i][1] = Math.min(res[i][1], res[i + 1][1] + distance);
        }

        int maxPeak = 0;

        for (int i = 1; i < res.length; i++) {
            int h1 = res[i - 1][1];
            int h2 = res[i][1];
            int distance = res[i][0] - res[i - 1][0];

            int peak = (int) (((long) h1 + h2 + distance) / 2);
            maxPeak = Math.max(maxPeak, peak);
        }

        return maxPeak;
    }
}