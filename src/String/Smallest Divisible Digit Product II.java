class Solution {
    public String smallestNumber(String num, long t) {
        long temp = t;
        int[] req = new int[4];
        int[] primes = {2, 3, 5, 7};

        // 1. Prime Factorization of t
        for (int i = 0; i < 4; i++) {
            while (temp % primes[i] == 0) {
                req[i]++;
                temp /= primes[i];
            }
        }

        // If t has prime factors other than 2, 3, 5, or 7
        if (temp > 1) return "-1";

        int[][] digitFactors = {
                {0, 0, 0, 0}, {0, 0, 0, 0}, {1, 0, 0, 0}, {0, 1, 0, 0},
                {2, 0, 0, 0}, {0, 0, 1, 0}, {1, 1, 0, 0}, {0, 0, 0, 1},
                {3, 0, 0, 0}, {0, 2, 0, 0}
        };

        // 2. Base check for edge cases where required digits EXCEED the length of `num`
        String reqStr = getDigits(req);
        if (reqStr.length() > num.length()) {
            return reqStr;
        }

        int firstZero = num.indexOf('0');
        if (firstZero == -1) firstZero = num.length();

        // Compute the cumulative prime factors provided by the original `num`
        int[] pref = new int[4];
        for (int i = 0; i < num.length(); i++) {
            int d = num.charAt(i) - '0';
            for (int j = 0; j < 4; j++) {
                pref[j] += digitFactors[d][j];
            }
        }

        // If `num` itself satisfies all conditions, return it
        if (firstZero == num.length()) {
            boolean ok = true;
            for (int j = 0; j < 4; j++) {
                if (pref[j] < req[j]) ok = false;
            }
            if (ok) return num;
        }

        // 3. Iterate backward, attempting to increment digits
        int[] tempReq = new int[4];
        for (int i = num.length() - 1; i >= 0; i--) {
            int d = num.charAt(i) - '0';

            // Remove the current digit from the prefix pool
            for (int j = 0; j < 4; j++) {
                pref[j] -= digitFactors[d][j];
            }

            // A prefix containing a '0' is completely invalid
            if (i > firstZero) continue;

            int spaceAfter = num.length() - 1 - i;

            for (int nextD = d + 1; nextD <= 9; nextD++) {
                for (int j = 0; j < 4; j++) {
                    tempReq[j] = Math.max(0, req[j] - pref[j] - digitFactors[nextD][j]);
                }

                String remDigits = getDigits(tempReq);

                // 4. If the required remaining digits can fit, pad with '1's and return
                if (remDigits.length() <= spaceAfter) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(num.substring(0, i));
                    sb.append(nextD);
                    int ones = spaceAfter - remDigits.length();
                    for (int k = 0; k < ones; k++) sb.append('1');
                    sb.append(remDigits);
                    return sb.toString();
                }
            }
        }

        // 5. Fallback: If no valid modification exists within the same length, we extend the length by 1
        int ones = num.length() + 1 - reqStr.length();
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < ones; k++) sb.append('1');
        sb.append(reqStr);
        return sb.toString();
    }

    private String getDigits(int[] req) {
        int c2 = req[0], c3 = req[1], c5 = req[2], c7 = req[3];

        // Greedily combine small prime factors into large single digits
        int c8 = c2 / 3; c2 %= 3;
        int c9 = c3 / 2; c3 %= 2;
        int c4 = c2 / 2; c2 %= 2;

        int c6 = 0;

        // Optimize for lexicographically smaller combinations (e.g., 2 & 6 is smaller than 3 & 4)
        if (c2 == 1 && c3 == 1) {
            c2 = 0; c3 = 0; c6 = 1;
        } else if (c3 == 1 && c4 == 1) {
            c2 = 1; c6 = 1; c3 = 0; c4 = 0;
        }

        // Construct the string in ascending order
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c2; i++) sb.append('2');
        for (int i = 0; i < c3; i++) sb.append('3');
        for (int i = 0; i < c4; i++) sb.append('4');
        for (int i = 0; i < c5; i++) sb.append('5');
        for (int i = 0; i < c6; i++) sb.append('6');
        for (int i = 0; i < c7; i++) sb.append('7');
        for (int i = 0; i < c8; i++) sb.append('8');
        for (int i = 0; i < c9; i++) sb.append('9');

        return sb.toString();
    }
}