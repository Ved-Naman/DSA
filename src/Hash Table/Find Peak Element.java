class Solution {
    public int findPeakElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0; i< nums.length; i++){
            map.put(nums[i],i);
        }
        int[] x = nums.clone();
        Arrays.sort(x);
        int y = x[x.length-1];
        return map.get(y);
    }
}