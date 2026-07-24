class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<Character> dictChars = new HashSet<>();
        for (String word : wordDict) {
            for (char c : word.toCharArray()) {
                dictChars.add(c);
            }
        }

        for (char c : s.toCharArray()) {
            if (!dictChars.contains(c)) {
                return false;
            }
        }

        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {

                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}