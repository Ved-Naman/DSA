class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxLen = 1;

        if (map.containsKey(1)) {
            int count = map.get(1);
            if (count % 2 == 0) {
                count--;
            }
            maxLen = Math.max(maxLen, count);
            map.remove(1);
        }

        for (int num : map.keySet()) {
            int currentLen = 0;
            long curr = num;

            while (map.containsKey((int) curr) && map.get((int) curr) >= 2) {
                currentLen += 2;
                curr *= curr;

                if (curr > 1_000_000_000) {
                    break;
                }
            }

            if (map.containsKey((int) curr)) {
                currentLen += 1;
            } else {
                currentLen -= 1;
            }

            maxLen = Math.max(maxLen, currentLen);
        }

        return maxLen;
    }
}