class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            freq[c-'a']++;
        }
        int odd = 0;
        String middle = "";
        for(int i = 0; i<26; i++){
            if(freq[i]%2 != 0){
                odd++;
                middle = String.valueOf((char) (i + 'a'));
            }
        }
        if(odd>1){
            return "";
        }
        StringBuilder left = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                // Take half of the count for the left side
                int halfCount = freq[i] / 2;
                char c = (char) (i + 'a');

                for (int j = 0; j < halfCount; j++) {
                    left.append(c);
                }
            }
        }
        String lef = left.toString();

        // .reverse() modifies the StringBuilder in place, giving us the descending right side
        String right = left.reverse().toString();

        return lef + middle + right;
    }
}