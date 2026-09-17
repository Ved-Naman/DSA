class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] best = new int[n];
        int sum = 0;
        int left = 0;
        int minLenSum = Integer.MAX_VALUE;
        int minLenSoFar = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {
                int currentLen = right - left + 1;

                if (left > 0 && best[left - 1] != Integer.MAX_VALUE) {
                    minLenSum = Math.min(minLenSum, currentLen + best[left - 1]);
                }

                minLenSoFar = Math.min(minLenSoFar, currentLen);
            }

            best[right] = minLenSoFar;
        }

        return minLenSum == Integer.MAX_VALUE ? -1 : minLenSum;
    }
}