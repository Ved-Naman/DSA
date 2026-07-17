class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        int[] count = new int[maxVal + 1];
        for (int num : nums) {
            count[num]++;
        }

        long[] exactGcdPairs = new long[maxVal + 1];

        for (int i = maxVal; i >= 1; i--) {
            long multipleCount = 0;

            for (int j = i; j <= maxVal; j += i) {
                multipleCount += count[j];
            }

            long pairs = multipleCount * (multipleCount - 1) / 2;

            for (int j = 2 * i; j <= maxVal; j += i) {
                pairs -= exactGcdPairs[j];
            }

            exactGcdPairs[i] = pairs;
        }

        long[] prefix = new long[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            prefix[i] = prefix[i - 1] + exactGcdPairs[i];
        }

        int[] result = new int[queries.length];
        for (int k = 0; k < queries.length; k++) {
            long target = queries[k];

            int left = 1;
            int right = maxVal;
            int ans = 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (prefix[mid] > target) {
                    ans = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            result[k] = ans;
        }

        return result;
    }
}