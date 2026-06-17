class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] len = new long[n];
        long currentLen = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '*') {
                if (currentLen > 0) currentLen--;
            } else if (c == '#') {
                currentLen *= 2;
            } else if (c == '%') {
            } else {
                currentLen++;
            }

            len[i] = currentLen;
        }

        if (k >= len[n - 1]) {
            return '.';
        }

        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            long prevL = (i == 0) ? 0 : len[i - 1];

            if (c == '#') {
                if (prevL > 0) {
                    k = k % prevL;
                }
            } else if (c == '%') {
                if (prevL > 0) {
                    k = prevL - 1 - k;
                }
            } else if (c == '*') {
            } else {
                if (k == prevL) {
                    return c;
                }
            }
        }

        return '.';
    }
}