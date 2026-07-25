class Solution {
    public int maxProduct(int n) {
        char[] digits = String.valueOf(n).toCharArray();

        Arrays.sort(digits);

        int len = digits.length;
        int largest = digits[len - 1] - '0';
        int secondLargest = digits[len - 2] - '0';

        return largest * secondLargest;
    }
}