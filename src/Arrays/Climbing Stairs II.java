class Solution {

    static class Node {
        int index;
        long cost;

        public Node(int index, long cost) {
            this.index = index;
            this.cost = cost;
        }
    }

    public int climbStairs(int n, int[] costs) {
        long[] distance = new long[n + 1];
        Arrays.fill(distance, Long.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.cost));

        distance[0] = 0;
        pq.offer(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int u = curr.index;
            long currentCost = curr.cost;

            if (u == n) {
                return (int) currentCost;
            }

            if (currentCost > distance[u]) {
                continue;
            }

            for (int jump = 1; jump <= 3; jump++) {
                int v = u + jump;

                if (v <= n) {
                    long edgeWeight = costs[v - 1] + (long) Math.pow(v - u, 2);
                    long newCost = currentCost + edgeWeight;

                    if (newCost < distance[v]) {
                        distance[v] = newCost;
                        pq.offer(new Node(v, newCost));
                    }
                }
            }
        }

        return (int) distance[n];
    }
}