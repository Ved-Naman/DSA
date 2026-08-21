class Solution {
    int count = 0; // Global variable to track valid arrangements

    public int countArrangement(int n) {
        // visited array tracks which numbers (1 to n) we have already used
        boolean[] visited = new boolean[n + 1];

        // Start trying to fill position 1
        backtrack(n, 1, visited);

        return count;
    }

    private void backtrack(int n, int pos, boolean[] visited) {
        // Base Case: If we passed position n, we successfully filled the array!
        if (pos > n) {
            count++;
            return;
        }

        // Try placing every number from 1 to n in the current 'pos'
        for (int i = 1; i <= n; i++) {

            // If the number isn't used yet AND it satisfies the Beautiful condition
            if (!visited[i] && (i % pos == 0 || pos % i == 0)) {

                // 1. CHOOSE: Mark the number as used
                visited[i] = true;

                // 2. EXPLORE: Move on to fill the next position
                backtrack(n, pos + 1, visited);

                // 3. UN-CHOOSE: Unmark the number so we can try a different path
                visited[i] = false;
            }
        }
    }
}