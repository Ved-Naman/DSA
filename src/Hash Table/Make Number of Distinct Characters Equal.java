class Solution {
    public boolean isItPossible(String word1, String word2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char c : word1.toCharArray()) {
            freq1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            freq2[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq1[i] == 0) continue;

            for (int j = 0; j < 26; j++) {
                if (freq2[j] == 0) continue;

                freq1[i]--;
                freq2[i]++;
                freq2[j]--;
                freq1[j]++;

                if (getDistinctCount(freq1) == getDistinctCount(freq2)) {
                    return true;
                }

                freq1[i]++;
                freq2[i]--;
                freq2[j]++;
                freq1[j]--;
            }
        }

        return false;
    }

    private int getDistinctCount(int[] freq) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                count++;
            }
        }
        return count;
    }
}