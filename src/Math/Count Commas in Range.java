class Solution {
    public int countCommas(int n) {
        int totalCommas = 0;

        if (n >= 1000) {
            totalCommas += (n - 999);
        }

        if (n >= 1000000) {
            totalCommas += (n - 999999);
        }

        if (n >= 1000000000) {
            totalCommas += (n - 999999999);
        }

        return totalCommas;
    }
}