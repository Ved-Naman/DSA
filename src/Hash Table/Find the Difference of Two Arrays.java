class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
        }

        List<Integer> uniqueToNums1 = new ArrayList<>();
        List<Integer> uniqueToNums2 = new ArrayList<>();

        for (int num : set1) {
            if (!set2.contains(num)) {
                uniqueToNums1.add(num);
            }
        }

        for (int num : set2) {
            if (!set1.contains(num)) {
                uniqueToNums2.add(num);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(uniqueToNums1);
        result.add(uniqueToNums2);

        return result;
    }
}