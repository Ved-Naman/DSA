class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        // 1. Set up frequency arrays for the alphabet
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // 2. Count the characters for s1 and the VERY FIRST window in s2
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        // 3. Slide the window across the rest of s2
        for (int i = 0; i < s2.length() - s1.length(); i++) {

            // If the frequencies match perfectly, we found a permutation!
            if (Arrays.equals(s1Count, s2Count)) {
                return true;
            }

            // The window moves right: Add the new character entering the window
            s2Count[s2.charAt(i + s1.length()) - 'a']++;

            // The window moves right: Remove the old character falling out of the window
            s2Count[s2.charAt(i) - 'a']--;
        }
        return Arrays.equals(s1Count, s2Count);
    }
}