class Solution {
    public int numSpecialEquivGroups(String[] words) {
        Set<String> seen = new HashSet<>();
        for(String word : words){
            int[] count = new int[52];
            for(int i = 0; i< word.length(); i++){
                char c = word.charAt(i);
                if(i%2==0){
                    count[c-'a']++;
                }else{
                    count[c-'a'+26]++;
                }
            }
            seen.add(Arrays.toString(count));
        }
        return seen.size();
    }
}