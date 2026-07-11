class Solution {

    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int completeComponent = 0;

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                if(isCompleteBFS(i, adj, visited)){
                    completeComponent++;
                }
            }
        }

        return completeComponent;
    }

    private boolean isCompleteBFS(int startNode, List<List<Integer>> adj, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        visited[startNode] = true;

        int nodeCount = 0;
        int edgeCount = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            nodeCount++;

            for (int neighbor : adj.get(current)) {
                edgeCount++;

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        edgeCount = edgeCount / 2;

        return edgeCount == nodeCount * (nodeCount - 1) / 2;
    }
}