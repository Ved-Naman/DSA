class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int[] d = stoneValue;
        int n = d.length;

        int next1 = 0;
        int next2 = 0;
        int next3 = 0;

        for (int i = n - 1; i >= 0; i--) {
            int maxDiff = Integer.MIN_VALUE;
            int take = 0;

            take += d[i];
            maxDiff = Math.max(maxDiff, take - next1);

            if (i + 1 < n) {
                take += d[i + 1];
                maxDiff = Math.max(maxDiff, take - next2);
            }

            if (i + 2 < n) {
                take += d[i + 2];
                maxDiff = Math.max(maxDiff, take - next3);
            }

            next3 = next2;
            next2 = next1;
            next1 = maxDiff;
        }

        if (next1 > 0) return "Alice";
        if (next1 < 0) return "Bob";
        return "Tie";
    }
}