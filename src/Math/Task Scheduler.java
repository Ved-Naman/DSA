class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26];
        int maxFreq = 0;

        for (char task : tasks) {
            frequencies[task - 'A']++;
            maxFreq = Math.max(maxFreq, frequencies[task - 'A']);
        }

        int maxFreqCount = 0;
        for (int freq : frequencies) {
            if (freq == maxFreq) {
                maxFreqCount++;
            }
        }

        int calculatedTime = (maxFreq - 1) * (n + 1) + maxFreqCount;

        return Math.max(calculatedTime, tasks.length);
    }
}