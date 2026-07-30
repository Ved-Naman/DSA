class Solution {
    public int minimumPushes(String word) {
        int totalPushes = 0;
        int n = word.length();

        for (int i = 0; i < n; i++) {
            // Integer division by 8 automatically groups the letters!
            int pushes = (i / 8) + 1;
            totalPushes += pushes;
        }

        return totalPushes;
    }
}