class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack= new Stack<>();
        for(int i = 0; i< n; i++){
            int curr= temperatures[i];
            while(!stack.isEmpty()&&curr>temperatures[stack.peek()]){
                int wait = stack.pop();
                answer[wait] = i - wait;
            }
            stack.push(i);
        }
        return answer;
    }
}