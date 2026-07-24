class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int MAX_XOR = 2048;

        boolean[] validTriplets = new boolean[MAX_XOR];
        boolean[] seenPairs = new boolean[MAX_XOR];

        for (int k = 0; k < nums.length; k++) {
            validTriplets[nums[k]] = true;

            for (int x = 0; x < MAX_XOR; x++) {
                if (seenPairs[x]) {
                    validTriplets[x ^ nums[k]] = true;
                }
            }

            for (int i = 0; i < k; i++) {
                seenPairs[nums[i] ^ nums[k]] = true;
            }
        }

        int count = 0;
        for (boolean isValid : validTriplets) {
            if (isValid) {
                count++;
            }
        }

        return count;
    }
}