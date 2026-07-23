class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[nums1.length];

        for (int i = 0; i < nums2.length; i++) {
            Integer match = map.higherKey(nums2[i]);

            if (match == null) {
                match = map.firstKey();
            }

            result[i] = match;

            if (map.get(match) == 1) {
                map.remove(match);
            } else {
                map.put(match, map.get(match) - 1);
            }
        }

        return result;
    }
}