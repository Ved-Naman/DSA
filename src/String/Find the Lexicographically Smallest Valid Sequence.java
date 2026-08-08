class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] match_len = new int[n + 1];

        int j = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            match_len[i] = match_len[i + 1];
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                match_len[i]++;
                j--;
            }
        }

        int[] res = new int[m];
        int resIdx = 0;
        j = 0;
        boolean changed = false;

        for (int i = 0; i < n && j < m; i++) {
            if (word1.charAt(i) == word2.charAt(j)) {
                res[resIdx++] = i;
                j++;
            } else if (!changed && match_len[i + 1] >= m - 1 - j) {
                changed = true;
                res[resIdx++] = i;
                j++;
            }
        }

        if (j == m) {
            return res;
        }
        return new int[0];
    }
}