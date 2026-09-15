class Solution {
    public int maxPalindromes(String s, int k) {
        char[] chars = s.toCharArray();
        int count = 0;
        int nextValid = 0;

        for (int i = k - 1; i < chars.length; i++) {

            int startK = i - k + 1;
            if (startK >= nextValid && isPalindrome(chars, startK, i)) {
                count++;
                nextValid = i + 1;
                continue;
            }

            int startK1 = i - k;
            if (startK1 >= nextValid && isPalindrome(chars, startK1, i)) {
                count++;
                nextValid = i + 1;
            }
        }

        return count;
    }

    private boolean isPalindrome(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}