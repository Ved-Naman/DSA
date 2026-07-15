class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> head = new PriorityQueue<>();
        PriorityQueue<Integer> tail = new PriorityQueue<>();

        long totalCost = 0;
        int left = 0;
        int right = costs.length - 1;

        for (int i = 0; i < k; i++) {

            while (head.size() < candidates && left <= right) {
                head.add(costs[left]);
                left++;
            }

            while (tail.size() < candidates && left <= right) {
                tail.add(costs[right]);
                right--;
            }

            int headMin = head.isEmpty() ? Integer.MAX_VALUE : head.peek();
            int tailMin = tail.isEmpty() ? Integer.MAX_VALUE : tail.peek();

            if (headMin <= tailMin) {
                totalCost += head.poll();
            } else {
                totalCost += tail.poll();
            }
        }

        return totalCost;
    }
}