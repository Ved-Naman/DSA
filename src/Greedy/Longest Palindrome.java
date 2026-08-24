class Solution {
    public int longestPalindrome(String s) {
        int[] charCounts = new int[128];

        for (char c : s.toCharArray()) {
            charCounts[c]++;
        }

        int length = 0;
        boolean hasOdd = false;

        for (int count : charCounts) {
            length += (count / 2) * 2;

            if (count % 2 != 0) {
                hasOdd = true;
            }
        }

        if (hasOdd) {
            length += 1;
        }

        return length;
    }
}