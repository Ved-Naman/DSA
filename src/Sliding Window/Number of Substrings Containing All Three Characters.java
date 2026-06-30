class Solution {
    public int numberOfSubstrings(String s) {
        int[] freq = new int[3];
        int left = 0;
        int count = 0;

        for (int right = 0; right < s.length(); right++) {
            // 1. Add the current character to our window
            freq[s.charAt(right) - 'a']++;

            // 2. Shrink the window from the left as much as possible while still valid
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                freq[s.charAt(left) - 'a']--;
                left++;
            }

            // 3. The current 'left' index exactly equals the number of valid starting points!
            count += left;
        }

        return count;
    }
}