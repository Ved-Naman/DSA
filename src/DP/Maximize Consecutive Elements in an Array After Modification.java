class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> dp = new HashMap<>();
        int ans = 0;

        for (int num : nums) {
            int extendToNext = dp.getOrDefault(num, 0) + 1;
            int extendToCurr = dp.getOrDefault(num - 1, 0) + 1;

            dp.put(num + 1, extendToNext);
            dp.put(num, extendToCurr);

            ans = Math.max(ans, Math.max(extendToNext, extendToCurr));
        }

        return ans;
    }
}