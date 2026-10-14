public class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num) {
            return "";
        }

        int nines = sum / 9;
        int remainder = sum % 9;
        int zeros = num - nines - (remainder > 0 ? 1 : 0);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nines; i++) {
            sb.append('9');
        }

        if (remainder > 0) {
            sb.append(remainder);
        }

        for (int i = 0; i < zeros; i++) {
            sb.append('0');
        }

        return sb.toString();
    }
}