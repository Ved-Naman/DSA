import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int[] left = new int[26];
        int[] right = new int[26];
        Arrays.fill(left, -1);

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (left[c] == -1) left[c] = i;
            right[c] = i;
        }

        List<String> result = new ArrayList<>();
        int lastEnd = -1;

        for (int i = 0; i < s.length(); i++) {
            if (i == left[s.charAt(i) - 'a']) {
                int newRight = findRightBound(s, i, left, right);

                if (newRight != -1) {
                    if (i > lastEnd) {
                        result.add("");
                    }
                    result.set(result.size() - 1, s.substring(i, newRight + 1));
                    lastEnd = newRight;
                }
            }
        }

        return result;
    }

    private int findRightBound(String s, int i, int[] left, int[] right) {
        int maxRight = right[s.charAt(i) - 'a'];

        for (int j = i; j <= maxRight; j++) {
            int c = s.charAt(j) - 'a';
            if (left[c] < i) {
                return -1;
            }
            maxRight = Math.max(maxRight, right[c]);
        }
        return maxRight;
    }
}