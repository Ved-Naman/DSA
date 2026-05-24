class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];
        int maxOverall = 0;

        for (int i = 0; i < n; i++) {
            maxOverall = Math.max(maxOverall, dfs(arr, d, i, dp));
        }

        return maxOverall;
    }

    private int dfs(int[] arr, int d, int current, int[] dp) {

        if (dp[current] != 0) {
            return dp[current];
        }

        int bestScore = 1;

        for (int j = current + 1; j <= Math.min(current + d, arr.length - 1); j++) {

            if (arr[j] >= arr[current]) {
                break;
            }

            int scoreIfWeJump = 1 + dfs(arr, d, j, dp);
            bestScore = Math.max(bestScore, scoreIfWeJump);
        }
        for (int j = current - 1; j >= Math.max(current - d, 0); j--) {

            if (arr[j] >= arr[current]) {
                break;
            }

            int scoreIfWeJump = 1 + dfs(arr, d, j, dp);
            bestScore = Math.max(bestScore, scoreIfWeJump);
        }

        dp[current] = bestScore;
        return bestScore;
    }
}