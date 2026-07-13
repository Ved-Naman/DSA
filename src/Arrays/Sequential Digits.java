class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        String master = "123456789";
        for(int i =2; i <=9; i++){
            for(int j =0; j<= 9-i; j++){
                String x = master.substring(j,j+i);
                int num = Integer.parseInt(x);
                if(num>=low && num<=high){
                    result.add(num);
                }
            }
        }
        return result;
    }
}