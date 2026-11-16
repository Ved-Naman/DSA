package Codeforces;

import java.util.*;

public class Forked {
    // Arrays to represent the possible directions a knight can move
    static int[] dx = {-1, 1, -1, 1};
    static int[] dy = {-1, -1, 1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases
        while (t-- > 0) {
            long a = scanner.nextLong(); // Knight's move parameters
            long b = scanner.nextLong();
            long xKing = scanner.nextLong(); // Position of the king
            long yKing = scanner.nextLong();
            long xQueen = scanner.nextLong(); // Position of the queen
            long yQueen = scanner.nextLong();
            // Inputs are read

            // Sets to store positions attacked by the knight when placed to attack king and queen
            Set<Pair> kingHits = new HashSet<>();
            Set<Pair> queenHits = new HashSet<>();

            // Calculate all possible positions that can be attacked by the knight
            for (int j = 0; j < 4; j++) {
                // Calculate positions attacked by the knight when placed to attack the king
                kingHits.add(new Pair(xKing + dx[j] * a, yKing + dy[j] * b));
                kingHits.add(new Pair(xKing + dx[j] * b, yKing + dy[j] * a));

                // Calculate positions attacked by the knight when placed to attack the queen
                queenHits.add(new Pair(xQueen + dx[j] * a, yQueen + dy[j] * b));
                queenHits.add(new Pair(xQueen + dx[j] * b, yQueen + dy[j] * a));
            }

            int ans = 0; // Variable to store the number of positions where the knight can fork the king and queen
            // Check for common positions in both sets
            for (Pair position : kingHits) {
                if (queenHits.contains(position)) {
                    ans++;
                }
            }

            System.out.println(ans); // Output the result for the current test case
        }
        scanner.close();
    }

    // Helper class to represent a pair of coordinates
    static class Pair {
        long x, y;

        Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}

// Time Complexity (TC): O(8*log2(8)) = O(8*3) = O(24)
// Space Complexity (SC): O(8)
