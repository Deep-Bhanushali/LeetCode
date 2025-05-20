class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0,right = n-1;
        while(top < m && right >= 0){
            if(matrix[top][right] < target){
                top++;
            }
            else if(matrix[top][right] > target){
                right--;
            }else{
                return true;
            }
        }
        return false;
    }
}