import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;

        // Edge case: If there is only 1 house, it takes 0 steps to visit.
        if (n == 1) return 0;

        // Target state: All bits are 1. 
        // If n = 3, (1 << 3) - 1 => (1000 in binary) - 1 => 0111 in binary (7)
        int finalState = (1 << n) - 1;

        // Queue will hold int arrays: {current_node, current_mask, steps_taken}
        Queue<int[]> queue = new LinkedList<>();

        // Visited array keeps track of [node][mask] to prevent infinite loops
        boolean[][] visited = new boolean[n][1 << n];

        // MULTI-SOURCE BFS: We can start our route at ANY house.
        // So, we put every single house into the queue as a valid starting point.
        for (int i = 0; i < n; i++) {
            int initialMask = 1 << i; // Turn on the i-th bit
            queue.add(new int[] {i, initialMask, 0});
            visited[i][initialMask] = true;
        }

        // Standard BFS Loop
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int mask = current[1];
            int steps = current[2];

            // Look at all connected houses (neighbors)
            for (int neighbor : graph[node]) {
                // Update our checklist (mask) using the bitwise OR operator '|'
                // This essentially says: Keep my old checklist, but also turn on the bit for 'neighbor'
                int nextMask = mask | (1 << neighbor);

                // Did we just check off the last house on our list?
                if (nextMask == finalState) {
                    return steps + 1; // Return the steps taken so far + 1 for this final move
                }

                // Have we been to this neighbor with this exact checklist before?
                if (!visited[neighbor][nextMask]) {
                    visited[neighbor][nextMask] = true; // Mark this specific state as seen
                    queue.add(new int[] {neighbor, nextMask, steps + 1}); // Add to queue to keep exploring
                }
            }
        }

        return -1; // Should theoretically never reach here for a connected graph
    }
}