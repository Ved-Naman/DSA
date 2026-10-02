class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>();
        dp.add(Arrays.asList(""));

        for (int k = 1; k <= n; k++) {
            List<String> currentLevel = new ArrayList<>();

            // Your formula logic: split k-1 pairs between 'i' and 'k-1-i'
            for (int i = 0; i < k; i++) {
                for (String left : dp.get(i)) {
                    for (String right : dp.get(k - 1 - i)) {
                        // Applying your formula: ( + left + ) + right
                        currentLevel.add("(" + left + ")" + right);
                    }
                }
            }
            dp.add(currentLevel);
        }
        return dp.get(n);
    }
}