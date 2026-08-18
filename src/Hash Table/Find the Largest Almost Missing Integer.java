class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> subarrayCount = new HashMap<>();

        for (int i = 0; i <= nums.length - k; i++) {
            Set<Integer> uniqueInWindow = new HashSet<>();
            for (int j = i; j < i + k; j++) {
                uniqueInWindow.add(nums[j]);
            }

            for (int num : uniqueInWindow) {
                subarrayCount.put(num, subarrayCount.getOrDefault(num, 0) + 1);
            }
        }

        int maxAns = -1;
        for (Map.Entry<Integer, Integer> entry : subarrayCount.entrySet()) {
            if (entry.getValue() == 1) {
                maxAns = Math.max(maxAns, entry.getKey());
            }
        }

        return maxAns;
    }
}