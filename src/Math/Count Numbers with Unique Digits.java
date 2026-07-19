class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;

        int total = 10;
        int currentCount = 9;
        int choices = 9;

        for (int i = 2; i <= n && i <= 10; i++) {
            currentCount *= choices;
            total += currentCount;
            choices--;
        }

        return total;
    }
}