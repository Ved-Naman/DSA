class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int x = matrix.length;
        int[] y = new int[x*x];
        int index = 0;
        for(int i =0; i<x; i++){
            for(int j = 0; j<x; j++){
                y[index] = matrix[i][j];
                index++;
            }
        }
        Arrays.sort(y);
        return y[k-1];
    }
}