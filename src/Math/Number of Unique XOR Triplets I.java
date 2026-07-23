class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return n;
        }

        int bitLength = Integer.toBinaryString(n).length();

        return 1 << bitLength;
    }
}