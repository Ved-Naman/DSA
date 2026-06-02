class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int landFirst = calculateBestTime(landStartTime, landDuration, waterStartTime, waterDuration);
        int waterFirst = calculateBestTime(waterStartTime, waterDuration, landStartTime, landDuration);
        return Math.min(landFirst, waterFirst);
    }

    private int calculateBestTime(int[] startA, int[] durationA, int[] startB, int[] durationB) {

        int minEndA = Integer.MAX_VALUE;
        for (int i = 0; i < startA.length; i++) {
            minEndA = Math.min(minEndA, startA[i] + durationA[i]);
        }

        int bestTotalTime = Integer.MAX_VALUE;
        for (int j = 0; j < startB.length; j++) {

            int boardTimeB = Math.max(minEndA, startB[j]);

            int finishTimeB = boardTimeB + durationB[j];

            bestTotalTime = Math.min(bestTotalTime, finishTimeB);
        }

        return bestTotalTime;
    }
}