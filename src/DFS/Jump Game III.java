class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return dfs(arr, start, visited);
    }

    private boolean dfs(int[] arr, int current, boolean[] visited) {
        if (current < 0 || current >= arr.length || visited[current]) {
            return false;
        }

        if (arr[current] == 0) {
            return true;
        }


        visited[current] = true;
        return dfs(arr, current + arr[current], visited) ||
                dfs(arr, current - arr[current], visited);
    }
}