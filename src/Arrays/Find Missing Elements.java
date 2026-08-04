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

--------------------------------------------------------------------------------



class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            int currentMissing = nums[i] + 1;

            while (currentMissing < nums[i + 1]) {
                result.add(currentMissing);
                currentMissing++;
            }
        }

        return result;
    }
}