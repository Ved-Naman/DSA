class Solution {
    /**
     * Finds the single number using the frequency counting approach (O(n) time, O(n) space).
     * @param nums The input array where every element appears twice except for one.
     * @return The single unique number.
     */
    public int singleNumber(int[] nums) {
        // Step 1: Count Frequencies
        // We use a HashMap to store the count of each number.
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            // Get the current count (defaulting to 0 if not present) and increment it by 1.
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Find the Single One
        // Iterate through the map entries to find the number with a count of 1.
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == 1) {
                // Return the key (the number) whose value (the count) is 1.
                return entry.getKey();
            }
        }

        // According to the constraints, a single number is guaranteed to exist.
        // This line is technically unreachable given the problem constraints,
        // but included for completeness in case of an empty array or missing element.
        return -1;
    }
}