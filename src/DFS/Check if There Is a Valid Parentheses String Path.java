class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if ((m + n - 1) % 2 != 0 || grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }

        boolean[][][] visited = new boolean[m][n][m + n];
        return dfs(grid, 0, 0, 0, visited, m, n);
    }

    private boolean dfs(char[][] grid, int r, int c, int bal, boolean[][][] visited, int m, int n) {
        if (r >= m || c >= n) return false;

        bal += grid[r][c] == '(' ? 1 : -1;

        int remainingSteps = (m - 1 - r) + (n - 1 - c);
        if (bal < 0 || bal > remainingSteps) return false;

        if (r == m - 1 && c == n - 1) return bal == 0;
        if (visited[r][c][bal]) return false;

        visited[r][c][bal] = true;

        return dfs(grid, r + 1, c, bal, visited, m, n) ||
                dfs(grid, r, c + 1, bal, visited, m, n);
    }
}