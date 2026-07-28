class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int maxFruits = 0;
        int left = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {
            int currentFruit = fruits[right];
            map.put(currentFruit, map.getOrDefault(currentFruit, 0) + 1);

            while (map.size() > 2) {
                int leftFruit = fruits[left];
                map.put(leftFruit, map.get(leftFruit) - 1);

                if (map.get(leftFruit) == 0) {
                    map.remove(leftFruit);
                }

                left++;
            }

            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }
}