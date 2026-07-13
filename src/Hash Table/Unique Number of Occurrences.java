class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> counts = new HashMap<>();
        for(int num : arr){
            counts.put(num,counts.getOrDefault(num, 0) + 1);
        }
        HashSet<Integer> seen = new HashSet<>(); //Create a HashSet to keep track of the frequencies we have seen
        for(int freq : counts.values()){ //loop through frequency
            if (!seen.add(freq)) {
                return false;
            }
        }
        return true;
    }
}


------------------------------------------------------------------------------------------------------



class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> counts = new HashMap<>();

        for (int num : arr) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> freqList = new ArrayList<>(counts.values());

        for (int i = 0; i < freqList.size(); i++) {
            for (int j = i + 1; j < freqList.size(); j++) {
                if (freqList.get(i).equals(freqList.get(j))) {
                    return false;
                }
            }
        }

        return true;
    }
}