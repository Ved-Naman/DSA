class Solution {
    public int thirdMax(int[] nums) {
        HashSet<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) {
            uniqueNums.add(num);
        }
        List<Integer> list = new ArrayList<>(uniqueNums);
        Collections.sort(list, Collections.reverseOrder());
        if (list.size() >= 3) {
            return list.get(2);
        } else {
            return list.get(0);
        }
    }
}