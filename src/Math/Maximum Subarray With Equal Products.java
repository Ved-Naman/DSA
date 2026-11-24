class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        long lcmo = 1;
        int maxval = 0;

        for (int num : nums) {
            lcmo = lcm(lcmo, num);
            if (num > maxval) {
                maxval = num;
            }
        }

        long maxpdt = lcmo * maxval;

        for (int i = 0; i < n; i++) {
            long prod = 1;
            long currentGcd = 0;
            long currentLcm = 1;

            for (int j = i; j < n; j++) {
                long val = nums[j];

                if (prod > maxpdt / val) {
                    break;
                }

                prod *= val;
                currentGcd = (j == i) ? val : gcd(currentGcd, val);
                currentLcm = lcm(currentLcm, val);

                if (prod == currentLcm * currentGcd) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}