class Solution {
    int maxDepth = 0;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        dfs(1, -1, 0, adj);

        int MOD = 1_000_000_007;
        long answer = 1;

        for (int i = 0; i < maxDepth - 1; i++) {
            answer = (answer * 2) % MOD;
        }

        return (int) answer;
    }

    private void dfs(int node, int parent, int depth, List<List<Integer>> adj) {
        maxDepth = Math.max(maxDepth, depth);

        for (int neighbor : adj.get(node)) {
            if (neighbor != parent) {
                dfs(neighbor, node, depth + 1, adj);
            }
        }
    }
}