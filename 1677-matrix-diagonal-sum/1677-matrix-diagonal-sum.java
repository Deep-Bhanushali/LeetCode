class Solution {
    public int diagonalSum(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int sum = 0;
        for(int i = 0; i < m; i++){
            sum+=mat[i][i];
            if(i != n-i-1){
                sum+=mat[i][n-i-1];
            }
        }
        return sum;

    }
}