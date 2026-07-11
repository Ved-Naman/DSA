class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int timestamp = 2;
        boolean rottedSomeone = true;

        while (rottedSomeone) {
            rottedSomeone = false;

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {

                    if (grid[r][c] == timestamp) {

                        if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                            grid[r - 1][c] = timestamp + 1;
                            rottedSomeone = true;
                        }

                        if (r + 1 < rows && grid[r + 1][c] == 1) {
                            grid[r + 1][c] = timestamp + 1;
                            rottedSomeone = true;
                        }

                        if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                            grid[r][c - 1] = timestamp + 1;
                            rottedSomeone = true;
                        }

                        if (c + 1 < cols && grid[r][c + 1] == 1) {
                            grid[r][c + 1] = timestamp + 1;
                            rottedSomeone = true;
                        }
                    }
                }
            }

            if (rottedSomeone) {
                timestamp++;
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    return -1;
                }
            }
        }

        return timestamp - 2;
    }
}