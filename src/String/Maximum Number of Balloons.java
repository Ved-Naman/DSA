class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        for(char c : text.toCharArray()){
            freq[c-'a']++;
        }
        int b = freq['b' - 'a'];
        int a = freq['a' - 'a'];
        int l = freq['l' - 'a'];
        int o = freq['o' - 'a'];
        int n = freq['n' - 'a'];

        int minBalloons = b;
        minBalloons = Math.min(minBalloons, a);
        minBalloons = Math.min(minBalloons, l / 2);
        minBalloons = Math.min(minBalloons, o / 2);
        minBalloons = Math.min(minBalloons, n);

        return minBalloons;
    }
}