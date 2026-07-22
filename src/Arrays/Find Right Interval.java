class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int currentEnd = intervals[i][1];
            int minStart = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int j = 0; j < n; j++) {
                int compareStart = intervals[j][0];

                if (compareStart >= currentEnd) {
                    if (compareStart < minStart) {
                        minStart = compareStart;
                        minIndex = j;
                    }
                }
            }

            result[i] = minIndex;
        }

        return result;
    }
}