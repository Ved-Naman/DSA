class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        List<Integer> doubled = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            doubled.add(nums[i]);
        }
        for (int i = 0; i < n; i++) {
            doubled.add(nums[i]);
        }

        int startIndex = n - k;

        for (int i = 0; i < n; i++) {
            nums[i] = doubled.get(startIndex + i);
        }
    }
}