class Solution {
    public int islandPerimeter(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    return dfs(grid, r, c);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return 1;
        }

        if (grid[r][c] == 0) {
            return 1;
        }

        if (grid[r][c] == -1) {
            return 0;
        }

        grid[r][c] = -1;

        int perimeter = 0;
        perimeter += dfs(grid, r + 1, c);
        perimeter += dfs(grid, r - 1, c);
        perimeter += dfs(grid, r, c + 1);
        perimeter += dfs(grid, r, c - 1);

        return perimeter;
    }
}