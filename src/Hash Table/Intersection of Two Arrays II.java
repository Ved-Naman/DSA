class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums1) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            int freq = count.getOrDefault(num, 0);
            if (freq > 0) {
                list.add(num);
                count.put(num, freq - 1);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}