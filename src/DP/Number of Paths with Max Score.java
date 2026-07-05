import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1_000_000_007;

        // DP tables padded by 1 to avoid OutOfBounds errors
        int[][] maxScore = new int[n + 1][n + 1];
        int[][] paths = new int[n + 1][n + 1];

        // Fill scores with -1 to represent unreachable cells
        for (int[] row : maxScore) {
            Arrays.fill(row, -1);
        }

        // Base Case: We start at the bottom right 'E'
        maxScore[n - 1][n - 1] = 0;
        paths[n - 1][n - 1] = 1;

        // The 3 directions we can pull data from: Down, Right, Down-Right
        int[][] dirs = {{1, 0}, {0, 1}, {1, 1}};

        // Loop backward from bottom-right to top-left
        for (int r = n - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {

                // Skip the starting square (we already initialized it)
                if (r == n - 1 && c == n - 1) continue;

                char ch = board.get(r).charAt(c);

                // If it's an obstacle, it stays unreachable (-1 score, 0 paths)
                if (ch == 'X') continue;

                int bestNeighborScore = -1;

                // 1. Find the highest score among the 3 neighbors
                for (int[] d : dirs) {
                    int prevR = r + d[0];
                    int prevC = c + d[1];
                    if (maxScore[prevR][prevC] > bestNeighborScore) {
                        bestNeighborScore = maxScore[prevR][prevC];
                    }
                }

                // If all neighbors are unreachable, this cell is unreachable too
                if (bestNeighborScore == -1) continue;

                long totalPaths = 0;

                // 2. Sum the paths of ONLY the neighbors that tied for the winning score
                for (int[] d : dirs) {
                    int prevR = r + d[0];
                    int prevC = c + d[1];
                    if (maxScore[prevR][prevC] == bestNeighborScore) {
                        totalPaths = (totalPaths + paths[prevR][prevC]) % MOD;
                    }
                }

                // Calculate the value of the current cell (S and E are worth 0)
                int currentVal = (ch == 'S' || ch == 'E') ? 0 : (ch - '0');

                // Save our dual-state memory for this cell
                maxScore[r][c] = bestNeighborScore + currentVal;
                paths[r][c] = (int) totalPaths;
            }
        }

        // If the start square has 0 paths, it means we could never reach the end
        if (paths[0][0] == 0) {
            return new int[]{0, 0};
        }

        return new int[]{maxScore[0][0], paths[0][0]};
    }
}