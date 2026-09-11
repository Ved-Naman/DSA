class Solution {
    public int totalNumbers(int[] digits) {
        int[] count = new int[10];
        for (int d : digits) {
            count[d]++;
        }

        int matches = 0;

        for (int i = 100; i <= 998; i += 2) {
            int hundreds = i / 100;
            int tens = (i / 10) % 10;
            int ones = i % 10;

            count[hundreds]--;
            count[tens]--;
            count[ones]--;

            if (count[hundreds] >= 0 && count[tens] >= 0 && count[ones] >= 0) {
                matches++;
            }

            count[hundreds]++;
            count[tens]++;
            count[ones]++;
        }

        return matches;
    }
}