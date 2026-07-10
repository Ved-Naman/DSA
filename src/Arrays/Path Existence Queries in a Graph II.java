class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[][] sortedNums = new int[n][2];
        for (int i = 0; i < n; i++) {
            sortedNums[i][0] = nums[i];
            sortedNums[i][1] = i;
        }

        Arrays.sort(sortedNums, (a, b) -> Integer.compare(a[0], b[0]));

        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[sortedNums[i][1]] = i;
        }

        int LOG = 18;
        int[][] st = new int[n][LOG];

        int right = 0;
        for (int i = 0; i < n; i++) {
            while (right < n && sortedNums[right][0] - sortedNums[i][0] <= maxDiff) {
                right++;
            }
            st[i][0] = right - 1;
        }

        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                st[i][j] = st[st[i][j - 1]][j - 1];
            }
        }

        int[] ans = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int u = pos[queries[q][0]];
            int v = pos[queries[q][1]];

            if (u == v) {
                ans[q] = 0;
                continue;
            }

            if (u > v) {
                int temp = u;
                u = v;
                v = temp;
            }

            int curr = u;
            int steps = 0;

            for (int j = LOG - 1; j >= 0; j--) {
                if (st[curr][j] < v) {
                    curr = st[curr][j];
                    steps += (1 << j);
                }
            }

            if (st[curr][0] >= v) {
                ans[q] = steps + 1;
            } else {
                ans[q] = -1;
            }
        }

        return ans;
    }
}