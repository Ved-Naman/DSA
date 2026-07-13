class Solution {
    public void moveZeroes(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> x = new ArrayList<>();
        for(int i =0; i< nums.length; i++){
            if(nums[i]==0){
                result.add(nums[i]);
            }else{
                x.add(nums[i]);
            }
        }
        x.addAll(result);
        for(int i = 0; i < nums.length; i++){
            nums[i] = x.get(i);
        }
    }
}


---------------------------------------------------------------------------



class Solution {
    public void moveZeroes(int[] nums) {
        int[] x = new int[nums.length];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                x[index] = nums[i];
                index++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = x[i];
        }
    }
}