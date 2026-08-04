class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i<n-1; i++){
            for (int j = nums[i] + 1; j < nums[i + 1]; j++) {
                result.add(j);
            }
        }
        return result;
    }
}