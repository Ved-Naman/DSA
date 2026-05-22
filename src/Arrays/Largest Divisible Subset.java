class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        for (int num : nums) {
            List<Integer> list = new ArrayList<>();
            list.add(num);
            subsets.add(list);
        }

        int maxSubsetIndex = 0;
        int maxSize = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {

                if (nums[i] % nums[j] == 0 && subsets.get(j).size() + 1 > subsets.get(i).size()) {

                    List<Integer> newList = new ArrayList<>(subsets.get(j));
                    newList.add(nums[i]);
                    subsets.set(i, newList);
                    if (newList.size() > maxSize) {
                        maxSize = newList.size();
                        maxSubsetIndex = i;
                    }
                }
            }
        }
        return subsets.get(maxSubsetIndex);
    }
}