class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int index = 0;
        for(int i=citations.length-1; i>=0;i--){
            if(citations[i]<citations.length-i){
                break;
            }
            index = citations.length-i;
        }
        return index;
    }
}