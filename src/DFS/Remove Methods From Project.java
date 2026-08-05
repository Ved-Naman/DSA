class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : invocations) {
            graph[edge[0]].add(edge[1]);
        }

        boolean[] suspicious = new boolean[n];
        dfs(k, graph, suspicious);

        for (int[] edge : invocations) {
            if (!suspicious[edge[0]] && suspicious[edge[1]]) {
                List<Integer> allMethods = new ArrayList<>(n);
                for (int i = 0; i < n; i++) {
                    allMethods.add(i);
                }
                return allMethods;
            }
        }

        List<Integer> remaining = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                remaining.add(i);
            }
        }
        return remaining;
    }

    private void dfs(int node, List<Integer>[] graph, boolean[] suspicious) {
        suspicious[node] = true;
        for (int next : graph[node]) {
            if (!suspicious[next]) {
                dfs(next, graph, suspicious);
            }
        }
    }
}