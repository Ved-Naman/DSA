class Solution {
    public String customSortString(String order, String s) {
        int[] rank = new int[26];
        Arrays.fill(rank, 26);

        for (int i = 0; i < order.length(); i++) {
            rank[order.charAt(i) - 'a'] = i;
        }

        Character[] sChars = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            sChars[i] = s.charAt(i);
        }

        Arrays.sort(sChars, (char1, char2) -> {
            return rank[char1 - 'a'] - rank[char2 - 'a'];
        });

        StringBuilder result = new StringBuilder();
        for (char c : sChars) {
            result.append(c);
        }

        return result.toString();
    }
}