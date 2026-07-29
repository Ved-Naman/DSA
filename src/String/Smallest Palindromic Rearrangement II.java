class Solution {
    // 10^10 is large enough to cover the max constraints of k, 
    // but small enough to prevent long overflow during multiplication.
    long MAX = 10_000_000_000L;

    public String smallestPalindrome(String s, int k) {
        // Step 1: Count character frequencies
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Step 2: Extract the half counts and identify the middle character
        int[] halfCount = new int[26];
        String midLetter = "";

        for (int i = 0; i < 26; i++) {
            halfCount[i] = count[i] / 2;
            if (count[i] % 2 != 0) {
                midLetter = String.valueOf((char) (i + 'a'));
            }
        }

        // Step 3: Check if k exceeds the total possible distinct palindromes
        long totalPerms = countArrangements(halfCount);
        if (k > totalPerms) {
            return "";
        }

        int halfLen = 0;
        for (int f : halfCount) {
            halfLen += f;
        }

        // Step 4: Greedily build the left half of the palindrome
        StringBuilder leftHalf = new StringBuilder();
        long currentK = k;

        for (int step = 0; step < halfLen; step++) {
            // Try placing the smallest alphabetical character at the current position
            for (int i = 0; i < 26; i++) {
                if (halfCount[i] == 0) continue;

                halfCount[i]--; // Tentatively place this character
                long arr = countArrangements(halfCount);

                if (arr >= currentK) {
                    leftHalf.append((char) (i + 'a'));
                    break; // Found the right character, move to the next position
                } else {
                    currentK -= arr; // Skip these permutations
                    halfCount[i]++;  // Backtrack and try the next character
                }
            }
        }

        // Step 5: Mirror the left half to create the full palindrome
        String left = leftHalf.toString();
        String right = leftHalf.reverse().toString();
        return left + midLetter + right;
    }

    // Helper 1: Calculate distinct permutations of a character frequency map
    private long countArrangements(int[] count) {
        int total = 0;
        for (int f : count) total += f;

        long res = 1;
        for (int f : count) {
            if (f == 0) continue;
            long ways = nCk(total, f);

            // Prevent overflow by capping at MAX
            if (MAX / res < ways) {
                res = MAX;
            } else {
                res *= ways;
            }
            total -= f; // Decrease available slots
        }
        return res;
    }

    // Helper 2: Calculate combinations (n Choose k) mathematically
    private long nCk(int n, int k) {
        if (k > n - k) k = n - k;
        long res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (n - i + 1) / i;
            if (res >= MAX) return MAX; // Early exit to prevent overflow
        }
        return res;
    }
}