class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] targetCount = countDigits(n);
        int powerOf2 = 1;

        for (int i = 0; i < 31; i++) {
            int[] currentCount = countDigits(powerOf2);

            if (Arrays.equals(targetCount, currentCount)) {
                return true;
            }

            powerOf2 = powerOf2 * 2;
        }

        return false;
    }

    private int[] countDigits(int num) {
        int[] counts = new int[10];

        while (num > 0) {
            int digit = num % 10;
            counts[digit]++;
            num = num / 10;
        }

        return counts;
    }
}