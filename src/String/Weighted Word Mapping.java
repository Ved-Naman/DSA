class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder s = new StringBuilder();
        for(String w : words){
            long currw = 0;
            for(char c : w.toCharArray()){
                currw+= weights[c-'a'];
            }
            int r = (int) (currw%26);
            char m = (char) ('z'- r);
            s.append(m);
        }
        return s.toString();
    }
}