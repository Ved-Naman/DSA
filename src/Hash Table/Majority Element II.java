class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> x = new HashMap<>();
        int y = nums.length/3;
        for(int num:nums){
            x.put(num,x.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : x.entrySet()){
            if(entry.getValue() > y){
                result.add(entry.getKey());
            }
        }
        return result;
    }
}