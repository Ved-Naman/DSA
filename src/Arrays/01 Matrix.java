class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int INF = 10000;

        // PHASE 0: The Setup
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] == 1) {
                    mat[r][c] = INF;
                }
            }
        }

        // SWEEP 1: Top-Left to Bottom-Right (Looking Up and Left)
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] > 0) {
                    if (r - 1 >= 0) {
                        mat[r][c] = Math.min(mat[r][c], mat[r - 1][c] + 1);
                    }
                    if (c - 1 >= 0) {
                        mat[r][c] = Math.min(mat[r][c], mat[r][c - 1] + 1);
                    }
                }
            }
        }

        // SWEEP 2: Bottom-Right to Top-Left (Looking Down and Right)
        for (int r = rows - 1; r >= 0; r--) {
            for (int c = cols - 1; c >= 0; c--) {
                if (mat[r][c] > 0) {
                    if (r + 1 < rows) {
                        mat[r][c] = Math.min(mat[r][c], mat[r + 1][c] + 1);
                    }
                    if (c + 1 < cols) {
                        mat[r][c] = Math.min(mat[r][c], mat[r][c + 1] + 1);
                    }
                }
            }
        }

        return mat;
    }
}