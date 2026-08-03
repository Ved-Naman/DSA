class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int total = 0;

        for (int i = 0; i < points.length; i++) {
            Map<Long, Integer> distCount = new HashMap<>();

            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                long d = getDistSq(points[i], points[j]);
                distCount.put(d, distCount.getOrDefault(d, 0) + 1);
            }

            for (int count : distCount.values()) {
                total += count * (count - 1);
            }
        }

        return total;
    }

    private long getDistSq(int[] p1, int[] p2) {
        long dx = p1[0] - p2[0];
        long dy = p1[1] - p2[1];
        return dx * dx + dy * dy;
    }
}