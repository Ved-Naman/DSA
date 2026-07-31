class Solution {
    public int minimumPushes(String word) {
        int[] count = new int[26];
        for(char c : word.toCharArray()){
            count[c-'a']++;
        }
        Arrays.sort(count);
        int push = 0;
        int index = 0;
        for(int i =25; i>=0; i--){
            if(count[i]==0){
                break;
            }
            int p = (index/8)+1;
            push+= count[i] * p;
            index++;
        }
        return push;
    }
}